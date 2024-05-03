package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            list1.add(list1.size()/2,"-");
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        startTime = System.currentTimeMillis();
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < 200_000; i++) {
            list2.add(list2.size()/2, "-");
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }

}
