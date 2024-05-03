package strings;

public class StringsTask5 {

    public static void main(String[] args) {
        String[] words = new String[]{
                "flower", "flow", "flight"
        };
        System.out.println(maxCoincidence(words));
    }

    private static String maxCoincidence(String[] words){
        int size = words.length;
        String sub = "";
        int minLength = words[0].length();
        for (String word : words) {
            int length = word.length();
            if(length < minLength) minLength = length;
        }
        for (int i = 0; i < minLength; i++) {
            char ch = words[0].charAt(i);
            int count = 0;
            for (String word : words) {
                if(word.charAt(i) == ch) count++;
            }
            if(count == size) sub += ch;
            else break;
        }
        return sub;
    }

}
