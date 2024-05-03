package input_output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadLine {

    public static void main(String[] args) {
        //task1
        try (FileReader fileReader = new FileReader("./text_files/names.txt")) {
            String line = readLine(fileReader);
            while (line != null) {
                if (line.startsWith("a") || line.startsWith("A")) {
                    System.out.println(line);
                }
                line = readLine(fileReader);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //task2
        try(FileReader fileReader = new FileReader("./text_files/file_1.txt");
            FileWriter fileWriter = new FileWriter("./text_files/file_2.txt")) {
            String line = readLine(fileReader);
            int lineCounter = 1;
            while (line != null) {
                if(lineCounter++ % 2 == 1){
                    fileWriter.write(line);
                }
                line = readLine(fileReader);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static String readLine() throws IOException {
        StringBuilder str = new StringBuilder();
        InputStreamReader streamReader = new InputStreamReader(System.in);
        char ch;
        ch = (char) streamReader.read();
        while (ch != '\n') {
            str.append(ch);
            ch = (char) streamReader.read();
        }
        if (str.isEmpty()) return null;
        return str.toString();
    }


    public static String readLine(Reader reader) throws IOException {
        StringBuilder str = new StringBuilder();
        char ch;
        ch = (char) reader.read();
        while (ch != '\n' && ch != (char) -1) {
            str.append(ch);
            ch = (char) reader.read();
        }
        if (str.isEmpty()) return null;
        return str.toString();
    }
}

