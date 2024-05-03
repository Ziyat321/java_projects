package regex;

public class RegexMain {

    public static void main(String[] args) {

        String ip = "23.7.115.26";
        boolean ipMatch = ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$");
        System.out.println(ipMatch);

        String phone = "+7 (707) 282-86-89";
        boolean phoneMatch = phone.matches("^\\+\\d\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}$");
        System.out.println(phoneMatch);

        String dateTime = "2024/01/23 14:15";
        boolean dateTimeMatch = dateTime.matches("^\\d{4}/\\d{2}/\\d{2}\\s\\d{2}(:\\d{2}){1,2}$");
        System.out.println(dateTimeMatch);

        String login = "_login";
        boolean loginMatch = login.matches("^[a-zA-Z_]\\w{4,}$");
        System.out.println(loginMatch);

        String text = "template     liquid    application";
        text = text.replaceAll("\\s+", " ");
        System.out.println(text);

        String text1 = "exodus liquid xenon sleep tax map matrix";
        text1 = text1.replaceAll("[a-zA-Z]*x[a-z]*", "!");
        System.out.println(text1);

        String text2 = "text liquid terminate map template letter";
        text2 = text2.replaceAll("(\\s|^)te[a-z]*", " !").trim();
        System.out.println(text2);

        String path = "http://google.com/sqd/23d";
        boolean pathMatch = path.matches("https?://\\w+.com(/\\w+)*");
        System.out.println(pathMatch);
    }

}
