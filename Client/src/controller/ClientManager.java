package controller;

import model.AccessType;
import model.User;

public class ClientManager {
    ConnectionManager connectionManager = new ConnectionManager();
    ConsoleManager console = new ConsoleManager();
    public void start() {
        connectionManager.connect();
    }
    public AccessType logIn(String mode){
        System.out.println("Enter your login: ");
        String login = console.getString();
        System.out.println("Enter your password: ");
        String password = console.getString();
        connectionManager.sendMessage(mode + " " + login + " " + password);
        String serverAnswer = receiveMessage();
        if(serverAnswer.equals("Failure")){
            System.out.println("Failed to sign in. Check your login and password");
            return null;
        }
        else{
            System.out.println("You are signed in");
            return AccessType.valueOf(serverAnswer);
        }
    }
    public void exit(){
        connectionManager.sendMessage("EXIT");
        connectionManager.close();
    }

    public String receiveMessage(){
        connectionManager.waitForMessage();
        return connectionManager.receiveMessage();
    }

}
