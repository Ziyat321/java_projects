package input_output_1;

import input_output_1.InfoComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataModifyMain1 {

    private final static String filePath = "./src/input_output_1/text_files/users.txt";

    public static void main(String[] args) {


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
                infoShow(login, password);
                break;
            case "2":
                changeData(login, password);
                break;
            case "3":
                deleteUser(login, password);
                break;
            case "4":
                sortBySalary();
                break;
            default:
                break;
        }


    }

    private static String[] loginPasswordGet() {
        String login;
        String password;
        do {
            System.out.print("Введите логин: ");
            login = ReadLine.readLine();
        } while (login == null);
        do {
            System.out.print("Введите пароль: ");
            password = ReadLine.readLine();
        } while (password == null);         // чтение логина и пароля
        return new String[]{login, password};
    }

    private static boolean loginPasswordExists(String login, String password) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = ReadLine.readLine(bufferedReader);
            while (line != null) {
                String[] info = line.split(", ");
                //System.out.println(info[0] + " " + info[1]);
                if (login.equals(info[0]) && password.equals(info[1])) {

                    return true;
                }
                line = ReadLine.readLine(bufferedReader);
                //System.out.println(line);
            }                                           // проверка на наличие введенного логина и пароля
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static String actionChoose() {
        System.out.println(" - Просмотреть данные [1]");
        System.out.println(" - Изменить данные [2]");
        System.out.println(" - Удалить данные [3]");
        System.out.println(" - Отсортировать по доходу [4]");

        System.out.print("Введите действие: ");
        String choice;
        choice = ReadLine.readLine();
        while (choice == null || !choice.equals("1") && !choice.equals("2") && !choice.equals("3")
                && !choice.equals("4")) {
            System.out.println("Данные введены неправильно.");
            System.out.print("Введите действие: ");
            choice = ReadLine.readLine();
        }
        //Выбор действия
        return choice;
    }

    private static void infoShow(String login, String password) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = ReadLine.readLine(bufferedReader);
            while (line != null) {
                String[] info = line.split(", ");
                if (login.equals(info[0]) && password.equals(info[1])) {
                    System.out.println("Данные пользователя: ");
                    System.out.println(" - Имя: " + info[2]);
                    System.out.println(" - Доход: " + info[3]);
                    break;
                }
                line = ReadLine.readLine(bufferedReader);            // вывод информации об имени и зарплате пользователя
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeData(String login, String password) {
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = ReadLine.readLine(bufferedReader);
            while (line != null) {
                String[] info = line.split(", ");
                if (!login.equals(info[0]) || !password.equals(info[1])) {
                    list.add(line);
                } else {
                    String name;
                    do {
                        System.out.print("Введите имя: ");
                        name = ReadLine.readLine();
                    } while (name == null);
                    String salary;
                    do {
                        System.out.print("Введите доход: ");
                        salary = ReadLine.readLine();
                    } while (salary == null);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(login).append(", ").append(password).append(", ");
                    stringBuilder.append(name).append(", ").append(salary).append("\n");
                    list.add(stringBuilder.toString());
                }
                line = ReadLine.readLine(bufferedReader);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }                                                      //изменить имя и зарплату пользователя

        infoWrite(list);
    }


    private static void deleteUser(String login, String password) {
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = ReadLine.readLine(bufferedReader);
            while (line != null) {
                String[] info = line.split(", ");
                if (!login.equals(info[0]) || !password.equals(info[1])) {
                    list.add(line);
                }
                line = ReadLine.readLine(bufferedReader);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        infoWrite(list);                                   // удаление пользователя из списка
    }

    private static void sortBySalary() {
        List<String[]> list = infoFromFile();
        Collections.sort(list, new InfoComparator());
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String[] strings : list) {
                bufferedWriter.write(strings[0] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void infoWrite(List<String> list) {
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String s : list) {
                bufferedWriter.write(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }                                                           // запись инфо в текстовик
    }

    private static List<String[]> infoFromFile() {
        List<String[]> infoList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = ReadLine.readLine(bufferedReader);
            while (line != null) {
                //System.out.println(line);
                String[] info = line.split(", ");
                String[] userSalary = new String[2];
                userSalary[0] = line;
                userSalary[1] = info[3];
                infoList.add(userSalary);
                line = ReadLine.readLine(bufferedReader);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return infoList;                                     // вернуть список из данных о пользователе и его зарплаты
    }
}
