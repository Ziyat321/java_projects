package strings;

public class StringsTask2 {

    public static void main(String[] args) {

        String text = "template application template task";
        String word = "abc";

        int wordSize = word.length();
//        String newWord = "";
//
//        for (int i = 0; i < wordSize; i++) {
//            newWord = newWord.concat("-");
//        }


        int size = text.length();
        char[] chars = new char[size];
        int start = text.indexOf(word);
        int end = start + wordSize;
        String newText;
        if (start == -1) {
            newText = text;
        } else {
            do {
                for (int i = start; i < end; i++) {
                    chars[i] = '-';
                }
                start = text.indexOf(word, start + 1);
                int x = start == -1 ? size : start;
                for (int i = end; i < x; i++) {
                    chars[i] = text.charAt(i);
                }
                end = start + wordSize;
            } while (start != -1);
            newText = new String(chars);
        }



        System.out.println(newText);

        //text = text.replace(word, newWord);
        //System.out.println(text);

       /* int start = 0;
        int finish = text.indexOf(" ");

        System.out.println("Первое слово: " + text.substring(start, finish));

        start = finish + 1;
        finish = text.indexOf(" ", finish + 1);

        System.out.println("Второе слово: " + text.substring(start, finish));

        int size = text.length();
        for (int i = 0; i < size; i++) {
            if (text.charAt(i) == ' ') {
                System.out.println("Первое слово: " + text.substring(0, i));
                break;
            }

        }

        for(int i = size - 1; i >=0; i--){
            if(text.charAt(i) == ' '){
                System.out.println("Последнее слово: " + text.substring(i + 1, size));
                break;
            }
        }*/
    }

}
