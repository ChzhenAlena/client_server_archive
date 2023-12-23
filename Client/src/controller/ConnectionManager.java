package controller;

import java.io.*;
import java.net.Socket;
import java.util.TreeMap;

public class ConnectionManager {
    String host = "127.0.0.1";
    int port = 8000;
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;
    public void connect(){
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Вы подключились к серверу");
        } catch (IOException e) {
            System.out.println("Не удалось подключиться к серверу. Возможно, он не запущен.");
            throw new RuntimeException(e);
        }
    }
    public void sendMessage(String message){
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void close(){
        try {
            writer.close();
            reader.close();
            socket.close();
            System.out.println("Соединение закрыто");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitForMessage(){
        try {
            while (socket.getInputStream().available() == 0)
                Thread.sleep(1000);
        } catch (InterruptedException | IOException e){
            throw new RuntimeException();
        }
    }
    public String receiveMessage(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
