package controller;

import java.io.*;
import java.net.Socket;

public class Client {
    ConnectionManager connectionManager = new ConnectionManager();
   // ClientManager clientManager = new ClientManager();
    public void start() {
        connectionManager.connect();
        //clientManager.authorize(connectionManager);





    }

}
