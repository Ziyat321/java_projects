package regex;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalRegexTask1 {

    public static void main(String[] args) {
        String text = "template liquid text apple letter test";
        Pattern pattern = Pattern.compile("\\ste[a-z]*|^te[a-z]*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }
    }
}
