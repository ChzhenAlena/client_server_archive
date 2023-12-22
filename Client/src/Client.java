import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 8000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            System.out.println("Connected to server");
            writer.write("Hello from client");
            writer.newLine();
            writer.flush();

            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
