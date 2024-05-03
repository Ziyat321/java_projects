package input_output;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class UsersMain {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("./text_files/users.txt");
             FileWriter fileWriter = new FileWriter("./text_files/users.txt", true)) {
            System.out.println("Введите логин и пароль через клавишу Enter: ");
            String login = ReadLine.readLine();
            String password = ReadLine.readLine();
            boolean found = false;
            String line = ReadLine.readLine(fileReader);
            while (line != null) {
                String[] info = line.split(", ");
                if (login.equals(info[0]) && password.equals(info[1])) {
                    System.out.println(info[2] + " " + info[3]);
                    found = true;
                    break;
                }
                line = ReadLine.readLine(fileReader);
            }
            /*if (!found) {
                System.out.println("Пользователя с таким логином и паролем не существует.");
                System.out.println("Для создания нового аккаунта введите логин, пароль, " +
                        "имя и доход через клавишу Enter: ");
                try (FileReader fileReader1 = new FileReader("./text_files/users.txt")) {

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            boolean sameLogin;
            boolean loginRetried = false;

            do {
                sameLogin = false;
                login = ReadLine.readLine();
                FileReader newFileReader = new FileReader("");
                line = ReadLine.readLine(newFileReader);
                while (line != null) {
                    String[] info = line.split(", ");
                    if (login.equals(info[0])) {
                        System.out.println("Пользователь с таким логином уже существует.");
                        System.out.println("Введите новый логин: ");
                        sameLogin = true;
                        loginRetried = true;
                        break;
                    }
                    line = ReadLine.readLine(fileReader);
                }
            } while (sameLogin);


            if (loginRetried) {
                System.out.println("Введите оставшуюся информацию через клавишу Enter: ");
            }
            password = ReadLine.readLine();
            String name = ReadLine.readLine();
            String salary = ReadLine.readLine();
            StringBuilder str = new StringBuilder();
            str.append(login).append(", ").append(password).append(", ").append(name);
            str.append(", ").append(salary);
            fileWriter.write(str.toString());*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

