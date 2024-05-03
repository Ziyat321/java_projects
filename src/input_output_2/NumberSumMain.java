package input_output_2;

import java.io.*;

public class NumberSumMain {

    final static String filePath1 = "./src/input_output_2/data_1.txt";
    final static String filePath2 = "./src/input_output_2/data_2.txt";
    final static String target = "./src/input_output_2/target.txt";

    public static void main(String[] args) {

        try (FileReader fileReader1 = new FileReader(filePath1);
             BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
             FileReader fileReader2 = new FileReader(filePath2);
             BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
             FileWriter fileWriter = new FileWriter(target);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line1;
            String line2;
            int num1;
            int num2;
            while ((line1 = readLine(bufferedReader1)) != null
                    & (line2 = readLine(bufferedReader2)) != null) {
                try {
                    if (line1.equals("\n")) num1 = 0;
                    else num1 = Integer.parseInt(line1);
                    if (line2.equals("\n")) num2 = 0;
                    else num2 = Integer.parseInt(line2);
                    bufferedWriter.write((num1 + num2) + "\n");
                } catch (Exception e) {
                    bufferedWriter.write("err\n");
                }
            }

            if (line1 == null) {
                do {
                    try {
                        if(line2 == null) break;
                        if (line2.equals("\n")) num2 = 0;
                        else num2 = Integer.parseInt(line2);
                        bufferedWriter.write(num2 + "\n");
                    } catch (Exception e) {
                        bufferedWriter.write("err\n");
                    }
                } while ((line2 = readLine(bufferedReader2)) != null);
            } else{
                do {
                    try {
                        if (line1.equals("\n")) num1 = 0;
                        else num1 = Integer.parseInt(line1);
                        bufferedWriter.write(num1 + "\n");
                    } catch (Exception e) {
                        bufferedWriter.write("err\n");
                    }
                } while ((line1 = readLine(bufferedReader2)) != null);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String readLine(Reader reader) {
        StringBuilder str = new StringBuilder();
        char ch;

        try {
            ch = (char) reader.read();
            if (ch == '\n') str.append(ch);
            while (ch != '\n' && ch != (char) -1) {
                str.append(ch);
                ch = (char) reader.read();
            }
            if (ch == (char) -1) return null;
            //System.out.println("Readline: " + str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str.toString();                         //универсальное считывание
    }

}
