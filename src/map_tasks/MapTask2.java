package map_tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTask2 {

    public static void main(String[] args) {

        String[] fruits = new String[]{"apple","banana",
        "melon","apple","pear","melon","strawberry"};

        Map<String, Integer> fruitToCount = new LinkedHashMap<>();

        int size = fruits.length;


      /*  for(int i = 0; i < size; i++){
            int count = 1;
            for(int j = i + 1; j < size; j++){
                if(fruits[i].equals(fruits[j])) {
                    count++;
                }
            }
            if(!fruitToCount.containsKey(fruits[i])) {
                fruitToCount.put(fruits[i], count);
            }

        }*/

        for(String fruit: fruits){
            if(!fruitToCount.containsKey(fruit)) {
                fruitToCount.put(fruit, 1);
            } else {
                fruitToCount.put(fruit, fruitToCount.get(fruit) + 1);
            }
        }

        System.out.println(fruitToCount);
    }

}
