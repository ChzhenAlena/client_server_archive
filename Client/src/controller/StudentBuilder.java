package controller;

import model.Student;

public class StudentBuilder {
    private static ConsoleManager console = new ConsoleManager();
    public static Student create(){
        Student student = new Student();
        System.out.println("Введите id: ");
        student.setId(console.getNumber());
        console.getString();
        System.out.println("Введите имя: ");
        student.setName(console.getString());
        System.out.println("Введите дату рождения: ");
        student.setBirthDate(console.getString());
        System.out.println("Введите номер группы: ");
        student.setGroupNumber(console.getNumber());
        return student;
    }
    public static void change(Student student) {
        setName(student);
        setBirthDate(student);
        setGroupNumber(student);
    }
    private static void setName(Student student){
        int answer;
        System.out.println("Имя: " + student.getName());
        System.out.println("Хотите изменить поле?\n1. да\n2. нет");
        answer = console.getNumber();
        while(answer < 1 || answer > 2){
            System.out.println("Нажмите 1 или 2");
            answer = console.getNumber();
        }
        console.getString();
        if(answer == 1) {
            System.out.println("Введите значение: ");
            student.setName(console.getString());
        }
    }
    private static void setBirthDate(Student student){
        int answer;
        System.out.println("Дата рождения: " + student.getBirthDate());
        System.out.println("Хотите изменить поле?\n1. да\n2. нет");
        answer = console.getNumber();
        while(answer < 1 || answer > 2){
            System.out.println("Нажмите 1 или 2");
            answer = console.getNumber();
        }
        console.getString();
        if(answer == 1) {
            System.out.println("Введите значение: ");
            student.setBirthDate(console.getString());
        }
    }
    private static void setGroupNumber(Student student){
        int answer;
        System.out.println("Номер группы: " + student.getGroupNumber());
        System.out.println("Хотите изменить поле?\n1. да\n2. нет");
        answer = console.getNumber();
        while(answer < 1 || answer > 2){
            System.out.println("Нажмите 1 или 2");
            answer = console.getNumber();
        }
        console.getString();
        if(answer == 1) {
            System.out.println("Введите значение: ");
            student.setGroupNumber(console.getNumber());
        }
    }

    public static void main(String[] args) {
        String str = String.valueOf(console.getNumber());
        System.out.println(str);
    }
}
