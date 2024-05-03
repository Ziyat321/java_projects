package strings;

public class StringsMain2 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String str  = "";

        for (int i = 0; i < 10_000; i++) {
            str += "-";
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        startTime = System.currentTimeMillis();

        StringBuilder str1 = new StringBuilder();

        for (int i = 0; i < 200_000; i++) {
            str1.append("-");
        }

        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

}
