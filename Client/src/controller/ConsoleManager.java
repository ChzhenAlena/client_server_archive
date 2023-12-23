package controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleManager {
    Scanner scanner;

    public ConsoleManager() {
        scanner = new Scanner(System.in);
    }

    public void printStartMenu(){
        String menu = "1. Войти в систему\n" +
                "2. Регистрация\n" +
                "3. Завершить";
        System.out.println(menu);
    }
    public void printAdminMenu(){
        String menu = "1. Просмотреть дело\n"+
                "2. Изменить дело\n" +
                "3. Создать дело\n" +
                "4. Удалить дело\n" +
                "5. Выйти из системы";
        System.out.println(menu);
    }
    public void printUserMenu(){
        String menu = "1. Просмотреть дело\n"+
                "2. Выйти из системы";
        System.out.println(menu);
    }

    public String getString() {
        String line = scanner.nextLine();
        return line;
    }

    public int getNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String getEmail() {
        String line;
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");//for RFC5322
        Matcher matcher;
        while (true) {
            line = scanner.nextLine();
            matcher = pattern.matcher(line);
            if (matcher.matches())
                return line;
            else {
                System.out.println("веденный email не соответствует стандарту RFC5322. Введите email заново");
            }
        }
    }
}