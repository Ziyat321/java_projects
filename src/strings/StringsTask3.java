package strings;

public class StringsTask3 {

    public static void main(String[] args) {

        String text = "liquid   template     application      text";



        int start = text.indexOf(' ');
        while (start != -1) {
            int end = start + 1;
            //System.out.println("s: " + start + ", e: " + end);
            char ch = text.charAt(start);
            while (ch == ' '){
                start++;
                ch = text.charAt(start);
                //System.out.println("s: " + start + ",n: " + ch);
            }
            text = text.substring(0, end) + text.substring(start);
            System.out.println(text);
            start = text.indexOf(' ', end);
        }

        System.out.println(text);

    }

}
