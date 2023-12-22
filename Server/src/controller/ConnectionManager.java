package controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
}
