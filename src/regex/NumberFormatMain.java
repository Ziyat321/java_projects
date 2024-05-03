package regex;

import java.util.Formatter;

public class NumberFormatMain {

    public static void main(String[] args) {

        String number = "24789321.254";
        String numberFormatted = numberFormatter(number);
        System.out.println(numberFormatted);
        int fractionCount = 4;
        String numberFormattedModified = numberFormatter(number, fractionCount);
        System.out.println(numberFormattedModified);
    }

    public static String numberFormatter(String number){
        String numberInteger = numberIntegerFormatted(number);
        StringBuilder str = new StringBuilder(numberInteger);
        int dotPos = number.indexOf(".");
        int numberSize = number.length();
        int integerSize = getIntegerSize(number, dotPos);
        if(dotPos != -1){
            str.append(",").append(number.substring(integerSize + 1, numberSize));
        }
        return str.toString();
    }

    private static String numberIntegerFormatted(String number){
        int dotPos = number.indexOf(".");
        int integerSize = getIntegerSize(number, dotPos);
        int pos = integerSize % 3;
        StringBuilder str = new StringBuilder(number.substring(0, pos));
        if(pos != 0) str.append(" ");
        while (pos < integerSize){
            if(pos == integerSize - 3){
                str.append(number.substring(pos, pos + 3));
            } else{
                str.append(number.substring(pos, pos + 3)).append(" ");
            }
            pos +=3;
        }
        return str.toString();
    }

    private static int getIntegerSize(String number, int dotPos){
        int numberSize = number.length();
        int integerSize;
        if(dotPos == -1){
            integerSize = numberSize;
        } else {
            integerSize = dotPos;
        }
        return integerSize;
    }

    public static String numberFormatter(String number, int fractionCounter){
        String numberInteger = numberIntegerFormatted(number);
        StringBuilder str = new StringBuilder(numberInteger);
        if(fractionCounter > 0){
            int dotPos = number.indexOf(".");
            if(dotPos == -1) {
                return str.append(",").append("0".repeat(fractionCounter)).toString();
            }
            int numberSize = number.length();
            int fractionLength = numberSize - dotPos - 1;
            if(fractionLength <= fractionCounter){
                int zeroCounter = fractionCounter - fractionLength;
                str.append(",").append(number.substring(dotPos + 1, dotPos + fractionLength + 1)).append("0".repeat(zeroCounter));
            } else{
                str.append(",").append(number.substring(dotPos + 1, dotPos + fractionCounter + 1));
            }
        }
        return str.toString();
    }
}
