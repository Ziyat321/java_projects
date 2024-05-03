package map_tasks;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTask1 {

    public static void main(String[] args) {

        Map<String, Integer> cityToCount = new LinkedHashMap<>();
        cityToCount.put("Москва", 12_100_000);
        cityToCount.put("Астана", 1_300_000);
        cityToCount.put("Киев", 5_700_000);
        cityToCount.put("Алмата", 2_200_000);

        Set<String> keys = cityToCount.keySet();
        for (String str: keys){
            int value = cityToCount.get(str);
            if(value > 5_000_000){
                System.out.println(str);
            }
        }

        int maxInh = 0;
        String maxCity = "";

        for(String str: keys){
            int value = cityToCount.get(str);
            if(value > maxInh){
                maxInh = value;
                maxCity = str;
            }
        }

        System.out.println("\n" + "Город с максимальным количеством населения - " + maxCity + " (" + maxInh + ").");

    }


}
