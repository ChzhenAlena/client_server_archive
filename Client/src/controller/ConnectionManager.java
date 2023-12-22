package controller;

import java.io.*;
import java.net.Socket;

public class ConnectionManager {
    String host = "127.0.0.1";
    int port = 8000;
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;
    ClientManager clientManager = new ClientManager();
    public void connect(){
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connected to server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void authorize(){

    }
    public void sendCommand(){
    }
}
