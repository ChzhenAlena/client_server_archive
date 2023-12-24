package controller;

import model.AccessType;
import model.Student;

public class ClientManager {
    ConnectionManager connectionManager = new ConnectionManager();
    ConsoleManager console = new ConsoleManager();
    public void start() {
        connectionManager.connect();
    }
    public AccessType logIn(String mode){
        System.out.println("Введите логин: ");
        String login = console.getString();
        System.out.println("Введите пароль: ");
        String password = console.getString();
        connectionManager.sendMessage(mode + " " + login + " " + password);
        String serverAnswer = receiveMessage();
        if(serverAnswer.equals("Failure") && mode.equals("SIGNIN")){
            System.out.println("Не получилось войти. Проверьте свой логин и пароль");
            return null;
        }
        if(serverAnswer.equals("Failure") && mode.equals("REGISTER")){
            System.out.println("Пользователь с таким логином уже зарегестрирован. Выберите другой логин?");
            return null;
        }
        else{
            System.out.println("Вы вошли");
            return AccessType.valueOf(serverAnswer);
        }
    }
    public void show(){
        System.out.println("Введите номер дела: ");
        int id = console.getNumber();
        connectionManager.sendMessage("SHOW " + id);
        Student student = connectionManager.receiveObject();
        System.out.println(student.toString());
    }
    public void create(){
        connectionManager.sendMessage("CREATE");
        if(connectionManager.receiveMessage().equals("OK")) {
            Student student = new Student(3, "dfwf", "wewre", 2342);
            connectionManager.sendObject(student);
        }
        /*System.out.println("Введите имя: ");
        student.setName(console.getString());
        System.out.println("Введите дату рождения: ");
        student.setBirthDate(console.getString());
        System.out.println("Введите номер группы: ");
        student.setGroupNumber(console.getNumber());*/


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
