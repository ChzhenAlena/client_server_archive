package controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8000;
    ConnectionManager connectionManager = new ConnectionManager();
    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            connectionManager.connect(serverSocket.accept());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
