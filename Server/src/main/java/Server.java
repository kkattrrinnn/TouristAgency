

import java.io.*;
import java.net.ServerSocket;
import java.sql.*;
import java.util.List;

public class Server {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "Hhf:W7N+at";
    private static final String URL = "jdbc:mysql://192.168.10.63:3306/MySQL";
    private static final String URLFIXED = URL + "?useSSL=false&serverTimezone=UTC";
    public static boolean loop = true;
    private static Connection connection;

    public static void main(String[] args) throws SQLException {



        DBProcessor db = new DBProcessor();
        connection = db.getConnection(URLFIXED, USERNAME, PASSWORD);
        //db.addUser(connection, "root", "root", "root");
        System.out.println(authorization("root", "root"));
        //System.out.println(authorization("Mary", "mary"));
        /*String query = "select * from touristagency.tours";
        Statement stat = connection.createStatement();
        ResultSet resSet = stat.executeQuery(query);
        while (resSet.next()) {
            System.out.println(resSet.getString("tour_name"));
        }*/

        try (ServerSocket server = new ServerSocket(8000))                                     // серверный сокет - он один!
        {
            System.out.println("Server started!");
            while (loop) {
                Phone phone = new Phone(server);                                                    // для каждого нового клиента новый сокет
                new Thread(() -> {                                                                  // отдельный новый поток для каждого клиента
                    String request = phone.readLine();
                    String response = (int) (Math.random() * 30 - 10) + "";
                    //try {Thread.sleep(4000);} catch (InterruptedException e) { throw new RuntimeException(e);}
                    phone.writeLine(response);
                    try {phone.close();} catch (IOException e) { throw new RuntimeException(e);}
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public static boolean authorization(String login, String password) throws SQLException {
        /* Поиск пользователя по логину */
        String query = "select user_id from touristagency.users where user_login=?";
        PreparedStatement prepQuery = connection.prepareStatement(query);
        prepQuery.setString(1,login);
        ResultSet resSet = prepQuery.executeQuery();
        /* Если логин найден - проверка пароля */
        if (resSet.next()) {
            int id = resSet.getInt("user_id");
            query = "select user_password, user_salt from touristagency.users where user_id=?";
            prepQuery = connection.prepareStatement(query);
            prepQuery.setInt(1,id);
            resSet = prepQuery.executeQuery();
            if (resSet.next()) {
                String psw = resSet.getString("user_password");
                String salt = resSet.getString("user_salt");
                List<byte[]> answer = DBProcessor.hashGeneration(password, salt);
                if (DBProcessor.bytesToHex(answer.get(0)).equals(psw)) {
                    return true;
                } else {
                    System.out.println("1 "+DBProcessor.bytesToHex(answer.get(0)));
                    System.out.println("2 "+psw);
                }
            }
        }
        return false;
    }




}
