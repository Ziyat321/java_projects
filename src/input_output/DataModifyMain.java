package input_output;

import javax.management.MBeanRegistration;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.SortedMap;

public class DataModifyMain {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("./text_files/users.txt");
             FileWriter fileWriter = new FileWriter("./text_files/users.txt", true)) {

            String[] autorization = loginPasswordGet();
            String login = autorization[0];
            String password = autorization[1];
            while (!loginPasswordExists(login, password)) {
                System.out.println("Пользователя с данным логином и паролем не существует.");
                autorization = loginPasswordGet();
                login = autorization[0];
                password = autorization[1];
            }                                 // Запрос логина и пароля пользователя

            String choice = actionChoose();   // Выбор действия

            switch (choice) {
                case "1":
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static String[] loginPasswordGet() throws IOException {
        String login;
        do {
            System.out.print("Введите логин: ");
            login = ReadLine.readLine();
        } while (login == null);
        String password;
        do {
            System.out.print("Введите пароль: ");
            password = ReadLine.readLine();
        } while (password == null);         // чтение логина и пароля

        return new String[]{login, password};
    }

    private static boolean loginPasswordExists(String login, String password) throws IOException {
        FileReader fileReader = new FileReader("./text_files/users.txt");
        String line = ReadLine.readLine(fileReader);
        while (line != null) {
            String[] info = line.split(", ");
            if (login.equals(info[0]) && password.equals(info[1])) {
                return true;
            }
            line = ReadLine.readLine(fileReader);
        }                                           // проверка на наличие введенного логина и пароля
        return false;
    }

    private static String actionChoose() throws IOException {
        System.out.println(" - Просмотреть данные [1]");
        System.out.println(" - Изменить данные [2]");
        System.out.println(" - Удалить данные [3]");

        System.out.print("Введите действие: ");
        String choice = ReadLine.readLine();
        while (choice == null || !choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("Данные введены неправильно.");
            System.out.print("Введите действие: ");
            choice = ReadLine.readLine();
        }                                                       //Выбор действия
        return choice;
    }

    private static void infoShow(String login, String password) throws IOException {
        FileReader fileReader = new FileReader("./text_files/users.txt");
        String line = ReadLine.readLine(fileReader);
        while (line != null) {
            String[] info = line.split(", ");
            if (login.equals(info[0]) && password.equals(info[1])) {
                System.out.println("Данные пользователя: ");
                System.out.println(" - Имя: " + info[2]);
                System.out.println(" - Доход: " + info[3]);
                break;
            }
            line = ReadLine.readLine(fileReader);
        }
    }
}
