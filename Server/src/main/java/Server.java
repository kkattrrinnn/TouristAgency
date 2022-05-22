import com.jdbc.DBProcessor;
import java.io.*;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "Hhf:W7N+at";
    private static final String URL = "jdbc:mysql://192.168.10.63:3306/MySQL";
    private static final String URLFIXED = URL + "?useSSL=false&serverTimezone=UTC";
    public static void main(String[] args) throws SQLException {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URLFIXED, USERNAME, PASSWORD);
        String query = "select * from touristagency.tours";
        Statement stat = conn.createStatement();
        ResultSet resSet = stat.executeQuery(query);
        while (resSet.next()) {
            System.out.println(resSet.getString("tour_name"));
        }
        conn.close();

        try (ServerSocket server = new ServerSocket(8000))                                          // серверный сокет - он один!
        {
            System.out.println("Server started!");
            while (true) {
                Phone phone = new Phone(server);                                                         // для каждого нового клиента новый сокет
                new Thread(() -> {                                                                  // отдельный новый поток для каждого клиента
                    String request = phone.readLine();
                    String response = (int) (Math.random() * 30 - 10) + "";
                    try {Thread.sleep(4000);} catch (InterruptedException e) { }
                    phone.writeLine(response);
                    try {phone.close();} catch (IOException e) { }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
