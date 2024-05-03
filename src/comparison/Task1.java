package comparison;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

        String[] words = new String[]{
                "liquid", "text", "template", "hi", "application"
        };

        Arrays.sort(words, new StringLengthCompare());

        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

    }

}
