package controller;

import java.io.*;
import java.net.ServerSocket;

public class ServerManager {
    private static final int port = 8000;
    ConnectionManager connectionManager = new ConnectionManager();
    FileManager fileManager = new FileManager();
    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            connectionManager.connect(serverSocket.accept());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void logIn(String login, String password){

    }
    public String[] receiveMessage(){
        connectionManager.waitForMessage();
        return connectionManager.receiveMessage().split(" ");
    }
}
