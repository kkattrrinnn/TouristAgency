import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

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
