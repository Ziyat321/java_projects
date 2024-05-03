package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain2 {

    public static void main(String[] args) {

        String text = "25 text 17 5 liquid 120 22 1 map";

        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(text);

        int sum = 0;
        while (matcher.find()){
            sum += Integer.parseInt(matcher.group());
        }
       // System.out.println(sum);

        String text1 = "z 5 2 1 b 6 7 c 8 9 z 6 2 b 1 z 3";
        Pattern pattern1 = Pattern.compile("z((\\s\\d+)+)");
        Matcher matcher1 = pattern1.matcher(text1);
        int sum1 = 0;
        while (matcher1.find()){
            String digitsGroup = matcher1.group(1);
            String[] digits = digitsGroup.trim().split(" ");
            for (String digit : digits) {
                sum1 += Integer.parseInt(digit);
            }
        }
        System.out.println(sum1);
    }

}
