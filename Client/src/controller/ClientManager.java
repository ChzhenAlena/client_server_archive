package controller;

import model.User;

import java.util.Scanner;

public class ClientManager {
    ConsoleManager console = new ConsoleManager();
    Scanner scanner = new Scanner(System.in);

    public void authorize(ConnectionManager connectionManager){
        console.printAuthorizationMenu();
        int command = console.getNumber();
        while (command != 1 || command != 2) {
            System.out.println("Press 1 or 2");
            command = console.getNumber();
        }
        User user = new User();
        System.out.println("Enter your login: ");
        user.setLogin(console.getString());
        System.out.println("Enter your password: ");
        user.setPassword(console.getString());
        switch (command){
            case 1: //connectionManager.register(login, password);
                    break;
            case 2: //connectionManager.login(login, password);
                    break;
            default:
                break;
        }

    }
}
