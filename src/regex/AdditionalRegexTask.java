package regex;

public class AdditionalRegexTask {

    public static void main(String[] args) {
        String[] array = {
                "-4.5", "liquid", "22", "7.5", "tax", "122$"
        };
        String numberCheck = "^-?\\d+(\\.\\d+)?$";
        String numberWithCurrencyCheck = "^-?\\d+(\\.\\d+)?\\$$";
        double sum = 0;
        for (String s : array) {
            if(s.matches(numberCheck)){
                sum += Double.parseDouble(s);
            } else if(s.matches(numberWithCurrencyCheck)){
                sum += Double.parseDouble(s.substring(0, s.length() - 1));
            }
        }
        System.out.println(sum);
    }

}
