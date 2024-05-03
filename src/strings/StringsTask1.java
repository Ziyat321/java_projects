package strings;

public class StringsTask1 {

    public static void main(String[] args) {

        String text = "application template liquid";
        String word = "template";

        if(text.contains(word)){
            System.out.println("Слово содержится.");
        } else {
            System.out.println("Слово не содержится.");
        }

        int pos = text.indexOf(word);
        if(pos >= 0){
            System.out.println("Слово содержится.");
        } else {
            System.out.println("Слово не содержится.");
        }

    }

}
