package comparison;

import java.util.*;

public class Task3
{

    public static void main(String[] args) {


        Map<String, Integer> cityToCount = new LinkedHashMap<>();
        cityToCount.put("Москва", 12_100_000);
        cityToCount.put("Астана", 1_300_000);
        cityToCount.put("Киев", 5_700_000);
        cityToCount.put("Алмата", 2_200_000);


        String[] cities = cityToCount.keySet().toArray(new String[0]);

        Arrays.sort(cities, new CitiesComparator(cityToCount));

        for (String city : cities) {
            System.out.println(city + " (" + cityToCount.get(city) + ")");
        }
        System.out.println();



    }



}
