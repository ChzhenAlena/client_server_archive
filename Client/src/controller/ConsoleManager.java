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
        int number;
        while(true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Введите число");
                scanner.next();
            }
            else
                return scanner.nextInt();
        }
    }


}