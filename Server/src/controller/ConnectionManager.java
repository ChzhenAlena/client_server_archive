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

    public void connect(ServerSocket serverSocket){
        try {
            this.socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Клиент подключился");
    }
    public void waitForMessage(){
        //System.out.println("В ожидании сообщения");
        try {
            while (socket.getInputStream().available() == 0) {
                Thread.sleep(1000);
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
        System.out.println("Сообщение получено: " + message.toString());
        return message.toString();
    }
    public void sendMessage(String message){
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendObject(model.Student student){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(student);
            System.out.println("Дело № " + student.getId() + " отправлено");
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public model.Student receiveObject(){
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            model.Student student = (model.Student)objectInputStream.readObject();
            System.out.println("Дело получено");
            return student;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            writer.close();
            reader.close();
            socket.close();
            System.out.println("Соединение закрыто");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
