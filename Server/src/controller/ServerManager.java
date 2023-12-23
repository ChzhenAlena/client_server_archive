package controller;

import model.AccessType;
import model.User;

import java.io.*;
import java.net.ServerSocket;

public class ServerManager {
    private static final int port = 8000;
    ConnectionManager connectionManager = new ConnectionManager();
    FileManager fileManager = new FileManager();
    model.Users users;
    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            connectionManager.connect(serverSocket.accept());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        users = fileManager.readUsersXML();

    }
    public void signIn(String login, String password){
        model.User user = users.findUser(login, password);
        String message;
        if(user == null)
            message = "Failure";
        else
            message = String.valueOf(user.getAccessType());
        connectionManager.sendMessage(message);
    }
    public void register(String login, String password){
        model.User user = new User(login, password, AccessType.READ);
        users.addUser(user);
        connectionManager.sendMessage("READ");
    }

    public String[] receiveMessage(){
        connectionManager.waitForMessage();
        return connectionManager.receiveMessage().split(" ");
    }
    public void close(){
        connectionManager.close();
    }
}
