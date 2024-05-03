package input_output_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadLine {

    public static void main(String[] args) {
        //task1
        try (FileReader fileReader = new FileReader("./text_files/names.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = readLine(bufferedReader);
            while (line != null) {
                if (line.startsWith("a") || line.startsWith("A")) {
                    System.out.println(line);
                }
                line = readLine(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //task2
        try (FileReader fileReader = new FileReader("./text_files/file_1.txt");
             FileWriter fileWriter = new FileWriter("./text_files/file_2.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line = readLine(bufferedReader);
            int lineCounter = 1;
            while (line != null) {
                if (lineCounter++ % 2 == 1) {
                    bufferedWriter.write(line);
                }
                line = readLine(bufferedReader);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static String readLine() {
        StringBuilder str = new StringBuilder();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
            char ch;
            //ch = (char) bufferedInputStream.read();
            while ((ch = (char) bufferedInputStream.read()) != '\n') {
                str.append(ch);
            }
            if (str.isEmpty()) return null;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str.toString();
        //считывание ввода с клавы
    }


    public static String readLine(Reader reader) {
        StringBuilder str = new StringBuilder();
        char ch;

        try {
            ch = (char) reader.read();
            if(ch == '\n') str.append(ch);
            while (ch != '\n' && ch != (char) -1) {
                str.append(ch);
                ch = (char) reader.read();
            }
            if(ch == (char) -1) return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str.toString();                         //универсальное считывание
    }
}

