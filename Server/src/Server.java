import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(
                ServerSocket serverSocket = new ServerSocket(8000);
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            System.out.println("Client connected");
            writer.write("Hello from server");
            writer.newLine();
            writer.flush();

            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
