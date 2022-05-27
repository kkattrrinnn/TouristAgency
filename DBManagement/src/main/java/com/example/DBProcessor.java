package com.example;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBProcessor {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "Hhf:W7N+at";
    private static final String URL = "jdbc:mysql://192.168.10.63:3306/MySQL";
    private static final String URLFIXED = URL + "?useSSL=false&serverTimezone=UTC";

    private static Connection connection;
    public DBProcessor() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());                                           // создание и регистрация драйвера
    }
    public static Connection getConnection() throws SQLException {         // соединение с БД
        if (connection != null)
            return connection;
        connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
        return connection;
    }

    /* Генерирование хеша пароля */
    public static List<byte[]> hashGeneration(String psw, String user_salt) {
        byte[] salt;
        if (user_salt == null) {
            SecureRandom random = new SecureRandom();
            salt = new byte[16];
            random.nextBytes(salt);
        } else {
            salt = hexStringToBytes(user_salt);
        }
        KeySpec spec = new PBEKeySpec(psw.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory;
        try {factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");}
            catch (NoSuchAlgorithmException e) {throw new RuntimeException(e);}
        byte[] hash;
        try {hash = factory.generateSecret(spec).getEncoded();}
            catch (InvalidKeySpecException e) {throw new RuntimeException(e);}
        List<byte[]> result = new ArrayList<byte[]>();
        result.add(hash);
        result.add(salt);
        return result;
    }

    public static byte[] hexStringToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b: a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /* Добавление нового польователя в БД */
    public static boolean addUser(String name, String login, String password) throws SQLException {
        boolean check = false;
        if (!name.equals("") && !login.equals("") && !password.equals("")) {
            List<byte[]> answer = hashGeneration(password, null);
            String queryInsert = "insert into touristagency.users (user_name, user_login, user_password, user_salt) values (?, ?, ?, ?)";
            PreparedStatement prepInsert = connection.prepareStatement(queryInsert);
            prepInsert.setString(1, name);
            prepInsert.setString(2, login);
            prepInsert.setString(3, bytesToHex(answer.get(0)));
            prepInsert.setString(4, bytesToHex(answer.get(1)));
            prepInsert.execute();
            check = true;
        }
        return check;
    }

    /* Добавление нового тура в БД */
    public void addTour(Connection connection, String name, String starting_point, String final_point,
                               String date, int duration, int price) throws SQLException {
        String queryInsert = "insert into touristagency.tours (tour_name, starting_point, final_point, " +
                            "date, duration, price) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement prepInsert = connection.prepareStatement(queryInsert);
        prepInsert.setString(1, name);
        prepInsert.setString(2, starting_point);
        prepInsert.setString(3, final_point);
        prepInsert.setString(4, date);
        prepInsert.setInt(5, duration);
        prepInsert.setInt(6, price);
        prepInsert.execute();
    }

    public static String[] getTours() throws SQLException {
        ArrayList<String> answer = new ArrayList<String>();
        answer.add("Выберите тур");
        String query = "select tour_name from touristagency.tours";
        PreparedStatement prepStat = getConnection().prepareStatement(query);
        ResultSet resSet = prepStat.executeQuery();
        while (resSet.next()) {
            answer.add(resSet.getString("tour_name"));
        }
        String[] a = answer.toArray(new String[0]);
        return a;
    }

    public static ArrayList<String> getInfoAboutTheTour(String name) throws SQLException {
        ArrayList<String> answer = new ArrayList<String>();
        String query = "select starting_point, final_point, date, duration, price from touristagency.tours where tour_name = ?";
        PreparedStatement prepQuery = connection.prepareStatement(query);
        prepQuery.setString(1, name);
        ResultSet resSet = prepQuery.executeQuery();
        while (resSet.next()) {
            answer.add(resSet.getString("starting_point"));
            answer.add(resSet.getString("final_point"));
            answer.add(resSet.getString("date"));
            answer.add(String.valueOf(resSet.getInt("duration")));
            answer.add(String.valueOf(resSet.getInt("price")));
        }
        return answer;
    }

    /* Удаление тура из БД */
    public void deleteTour(int tour_id) throws SQLException {
        String queryDelete = "delete from touristagency.tours where tour_id = ?";
        PreparedStatement prepDelete = connection.prepareStatement(queryDelete);
        prepDelete.setInt(1, tour_id);
        prepDelete.execute();
    }

    /* Добавление нового заказа в БД */
    public static void addOrder(int user_id, int tour_id) throws SQLException {
        String queryInsert = "insert into touristagency.orders (user_id, tour_id) values (?, ?)";
        PreparedStatement prepInsert = connection.prepareStatement(queryInsert);
        prepInsert.setInt(1, user_id);
        prepInsert.setInt(2, tour_id);
        prepInsert.execute();
    }

    public static int getTourId(String tour_name) throws SQLException {
        String query = "select tour_id from touristagency.tours where tour_name = ?";
        PreparedStatement prepInsert = connection.prepareStatement(query);
        prepInsert.setString(1, tour_name);
        ResultSet resSet = prepInsert.executeQuery();
        if (resSet.next()) {
            return resSet.getInt("tour_id");
        }
        return 0;
    }

    /* Удаление заказа из БД */
    public void deleteOrder(int order_id) throws SQLException {
        String queryDelete = "delete from touristagency.orders where order_id = ?";
        PreparedStatement prepDelete = connection.prepareStatement(queryDelete);
        prepDelete.setInt(1, order_id);
        prepDelete.execute();
    }
}
