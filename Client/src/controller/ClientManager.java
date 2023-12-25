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
        if(serverAnswer.equals("FAIL") && mode.equals("SIGNIN")){
            System.out.println("Не получилось войти. Проверьте свой логин и пароль");
            return null;
        }
        if(serverAnswer.equals("FAIL") && mode.equals("REGISTER")){
            System.out.println("Пользователь с таким логином уже зарегестрирован. Выберите другой логин");
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
        if(connectionManager.receiveMessage().equals("FAIL")){
            System.out.println("Дела с таким номером нет");
        }
        else{
            Student student = connectionManager.receiveObject();
            System.out.println(student.toString());
        }

    }
    public void create(){
        connectionManager.sendMessage("CREATE");
        if(connectionManager.receiveMessage().equals("OK")) {
            Student student = StudentBuilder.create();
            connectionManager.sendObject(student);
            while(connectionManager.receiveMessage().equals("FAIL")){
                System.out.println("Пользователь с таким id уже существует. Введите другой id. Введите -1, чтобы не создавать пользователя");
                String number = console.getString();
                connectionManager.sendMessage(number);
            }
        }
    }
    public void change(){
        System.out.println("Введите номер дела: ");
        int id = console.getNumber();
        connectionManager.sendMessage("CHANGE " + id);
        if(connectionManager.receiveMessage().equals("FAIL")){
            System.out.println("Дела с таким номером нет");
        }
        else{
            Student student = connectionManager.receiveObject();
            StudentBuilder.change(student);
            connectionManager.sendObject(student);
            System.out.println("Дело отправлено");
        }

    }
    public void delete(){
        System.out.println("Введите номер дела: ");
        int id = console.getNumber();
        connectionManager.sendMessage("DELETE " + id);
        if(connectionManager.receiveMessage().equals("OK")) {
            System.out.println("Дело удалено");
        }
        else
            System.out.println("Дело не было найдено");
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
