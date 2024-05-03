package generics;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ElementCounter {

    public static void main(String[] args) {

        Integer[] nums = { 1, 2, 1, 1, 3, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        map = elementCounter(nums);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(key + ": " + map.get(key));
        }

    }

    @SuppressWarnings("unchecked")
    private static <T> Map<T, Integer> elementCounter(T[] array){
        Class<?> arrayItemType = array.getClass().componentType();
        Map<T, Integer> map = new HashMap<>();
        while (array.length != 0) {
            int counter = 1;
            for (int j = 1; j < array.length; j++) {
                if(array[0].equals(array[j])) counter++;
            }
            map.put(array[0], counter);
            T[] temp = (T[]) Array.newInstance(arrayItemType, array.length - counter);
            int pos = 0;
            for (int j = 0; j < array.length; j++) {
                if(!array[j].equals(array[0])) temp[pos++] = array[j];
            }
            array = temp;
        }
        return map;
    }

}
