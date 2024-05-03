package strings;

public class StringsTask4 {

    public static void main(String[] args) {
        String text = "template liquid transaction";
        System.out.println(myIndexOf(text, "online"));
    }

    private static int myIndexOf(String text, String target){
        char[] chars = text.toCharArray();
        for(int i = 0; i < text.length(); i++){
            int count = i;
            for(int j = 0; j < target.length(); j++){
                if(chars[count] == target.charAt(j)){
                    count++;
                    if(count >= text.length()) break;
                }
                else break;
            }
            if(count - i == target.length()) return i;
        }
        return -1;
    }
}
