package controller;

import model.AccessType;
import model.Student;
import model.User;

import java.io.*;
import java.net.ServerSocket;

public class ServerManager {
    private static final int port = 8000;
    ConnectionManager connectionManager = new ConnectionManager();
    FileManager fileManager = new FileManager();
    ServerSocket serverSocket;
    model.Users users;
    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            //connectionManager.connect(serverSocket.accept());

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void connect(){
        connectionManager.connect(serverSocket);
        users = fileManager.readUsersXML();
    }
    public void signIn(String login, String password){
        model.User user = users.findUser(login, password);
        String message;
        if(user == null) {
            message = "FAIL";
            System.out.println("Пользователь не найден");
        }
        else {
            message = String.valueOf(user.getAccessType());
            System.out.println("Пользователь найден");
        }
        connectionManager.sendMessage(message);
    }
    public void register(String login, String password){
        model.User user = new User(login, password, AccessType.READ);
        users.addUser(user);
        connectionManager.sendMessage("READ");
        System.out.println("Пользователь добавлен");
    }
    public void sendStudent(String id){
        Student student =  fileManager.readStudentFromFile(id);
        if(student == null){
            connectionManager.sendMessage("FAIL");
            System.out.println("Дело № " + id + " не найдено");
        }
        else{
            connectionManager.sendMessage("OK");
            connectionManager.sendObject(student);
        }
    }
    public boolean createStudent(){
        connectionManager.sendMessage("OK");
        Student student = connectionManager.receiveObject();
        while(fileManager.fileExists(String.valueOf(student.getId()))){
            System.out.println("Такое дело уже есть");
            connectionManager.sendMessage("FAIL");
            String[] newId = receiveMessage();
            if(newId[0].equals("-1")) {
                System.out.println("Такое дело уже существует. Пользователь передумал создавать дело");
                connectionManager.sendMessage("OK");
                return false;
            }
            student.setId(Integer.parseInt(newId[0]));
        }
        fileManager.writeStudentToFile(student);
        connectionManager.sendMessage("OK");
        System.out.println("Дело № " + student.getId() + " добавлено");
        return true;
    }
    public void deleteStudent(String id){
        if(fileManager.deleteStudentFile(id)) {
            connectionManager.sendMessage("OK");
            System.out.println("Дело № " + id + " удалено");
        }
        else {
            connectionManager.sendMessage("FAIL");
            System.out.println("Дело № " + id + " не найдено");
        }
    }

    public void changeStudent(String id){
        System.out.println("sdjfhwfjklwfjkl");
        if(!fileManager.fileExists(id)){
            connectionManager.sendMessage("FAIL");
            System.out.println("Дело № " + id + " не найдено");
        }
        else {
            connectionManager.sendMessage("OK");
            Student student = fileManager.readStudentFromFile(id);
            connectionManager.sendObject(student);
            student = connectionManager.receiveObject();
            fileManager.writeStudentToFile(student);
            System.out.println("Дело № " + id + " изменено");
        }
        /*Student student =  fileManager.readStudentFromFile(id);
        if(student == null){
            connectionManager.sendMessage("FAIL");
            System.out.println("Дело № " + id + " не найдено");
        }
        else{
            connectionManager.sendMessage("OK");
            connectionManager.sendObject(student);
            student = connectionManager.receiveObject();
            fileManager.writeStudentToFile(student);
        }*/
    }
    public String[] receiveMessage(){
        connectionManager.waitForMessage();
        return connectionManager.receiveMessage().split(" ");
    }
    public void disconnect(){
        connectionManager.close();
        fileManager.writeUsersXML(users);
    }
}
