package warm_up;

public class MyIndexOf {

    public static void main(String[] args) {
        String str = "hello template liquid transaction";
        System.out.println(myIndexOf(str, "template"));
        System.out.println(myIndexOf(str, "transactiondd"));
        System.out.println(myIndexOf(str, "template", 10));
        System.out.println(lastIndexof(str, "liquid"));
        System.out.println(lastIndexof(str, "dff"));

        String str1 = "aabbbbaaaaafffssssssxxxqqbb";
        maxSequentChar(str1);
    }

    static int myIndexOf(String str, String substring) {
        return myIndexOf(str, substring, 0);
    }

    static int myIndexOf(String str, String substring, int startPos) {
        if (substring.length() > str.length()) return -1;
        for (int i = startPos; i < str.length(); i++) {
            int k = i;
            for (int j = 0; j < substring.length(); j++) {
                if (k < str.length()) {
                    if (str.charAt(k++) != substring.charAt(j)) break;
                } else return -1;
            }
            if (k > str.length()) return -1;
            if (k == i + substring.length()) return i;
        }
        return -1;
    }

    static int lastIndexof(String str, String substring) {
        if (substring.length() > str.length()) return -1;
        for (int i = str.length() - substring.length(); i >= 0; i--) {
            int k = i;
            for (int j = 0; j < substring.length(); j++) {
                if (str.charAt(k++) != substring.charAt(j)) break;
            }
            if (k == i + substring.length()) return i;
        }
        return -1;
    }

    static void maxSequentChar(String str){
        if(str.length() == 0){
            System.out.println("The text is empty");
        } else{
            char ch = str.charAt(0);
            int maxPrev = 1;
            int  k = 0;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i) == ch) maxPrev++;
                else {
                    k = i;
                    break;
                }
            }

            System.out.println(ch);
            System.out.println(k);
            System.out.println(maxPrev);
            char chPrev = ch;
            int max = 0;
            for (int i = k; i < str.length(); i++) {
                if(str.charAt(i) == ch) max++;
                else {
                    if(max == 0){
                        ch = str.charAt(k);
                        max++;
                    } else{
                        if(max > maxPrev) {
                            maxPrev = max;
                            chPrev = ch;
                        }
                        ch = str.charAt(i);
                        max = 1;
                    }
                }
            }

            System.out.println(chPrev + ": " + maxPrev);
        }
    }
}
