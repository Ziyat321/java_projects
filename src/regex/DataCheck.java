package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataCheck {

    public static void main(String[] args) {

        final String path = "./src/regex/data.txt";
        final String formatCheck = "[А-Я][а-я]+\\s[А-Я][а-я]+,\\s\\d+\\sлет,\\semail:\\s\\w+@\\w+(\\.\\w+)*\\.com";
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.matches(formatCheck)){
                    System.out.println(line);
                } else {
                    System.out.println("Формат не корректен.");
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
