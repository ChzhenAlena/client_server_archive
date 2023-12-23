package controller;

import model.AccessType;
import model.User;

public class ClientManager {
    ConnectionManager connectionManager = new ConnectionManager();
    ConsoleManager console = new ConsoleManager();
    public void start() {
        connectionManager.connect();
    }
    public void logIn(model.User user){
        user = new User();
        System.out.println("Enter your login: ");
        user.setLogin(console.getString());
        System.out.println("Enter your password: ");
        user.setPassword(console.getString());
        user.setAccessType(AccessType.READ);
        connectionManager.sendMessage("LOGIN " + user.getLogin() + " " + user.getPassword());
    }

}
