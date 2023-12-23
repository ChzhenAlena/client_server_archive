package controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {

    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

    public void connect(Socket socket){
        try {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client connected");
    }
    public void waitForMessage(){
        System.out.println("Waiting for a message");
        try {
            while (socket.getInputStream().available() == 0) {
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public String receiveMessage(){
        StringBuilder message = new StringBuilder();
        try {
            while(reader.ready()) {
                message.append(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message.toString();
    }
}
