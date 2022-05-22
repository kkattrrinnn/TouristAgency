import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBProcessor {
    private Connection connection;
    public DBProcessor() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());                                           // создание и регистрация драйвера
    }
    public Connection getConnection(String url, String username, String password) throws SQLException {         // соединение с БД
        if (connection != null)
            return connection;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /* Генерирование хеша пароля */
    private static byte[] hashGeneration(String psw) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(psw.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory;
        try {factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");}
            catch (NoSuchAlgorithmException e) {throw new RuntimeException(e);}
        byte[] hash;
        try {hash = factory.generateSecret(spec).getEncoded();}
            catch (InvalidKeySpecException e) {throw new RuntimeException(e);}
        return hash;
    }

    /* Добавление нового польователя в БД */
    public void addUser(Connection connection, String name, String login, String password) throws SQLException {
        byte[] hashedPassword = hashGeneration(password);
        String queryInsert = "insert into touristagency.users (user_name, user_login, user_password) values (?, ?, ?)";
        PreparedStatement prepInsert = connection.prepareStatement(queryInsert);
        prepInsert.setString(1, name);
        prepInsert.setString(2, login);
        prepInsert.setString(3, String.valueOf(hashedPassword));
        prepInsert.execute();
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

    /* Удаление тура из БД */
    public void deleteTour(Connection connection, int tour_id) throws SQLException {
        String queryDelete = "delete from touristagency.tours where tour_id = ?";
        PreparedStatement prepDelete = connection.prepareStatement(queryDelete);
        prepDelete.setInt(1, tour_id);
        prepDelete.execute();
    }

    /* Добавление нового заказа в БД */
    public void addOrder(Connection connection, int user_id, int tour_id) throws SQLException {
        String queryInsert = "insert into touristagency.orders (user_id, tour_id) values (?, ?)";
        PreparedStatement prepInsert = connection.prepareStatement(queryInsert);
        prepInsert.setInt(1, user_id);
        prepInsert.setInt(2, tour_id);
        prepInsert.execute();
    }

    /* Удаление заказа из БД */
    public void deleteOrder(Connection connection, int order_id) throws SQLException {
        String queryDelete = "delete from touristagency.orders where order_id = ?";
        PreparedStatement prepDelete = connection.prepareStatement(queryDelete);
        prepDelete.setInt(1, order_id);
        prepDelete.execute();
    }
}
