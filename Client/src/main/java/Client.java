import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000) )
        {
            System.out.println("Connected to server");

            String request = "na-na";
            System.out.println("Request: " + request);
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println("Response: " + response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
