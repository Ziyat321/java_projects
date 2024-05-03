import java.util.*;

public class ArrayTask1 {

    public static void main(String[] args) {
        Map<String , int[]> map = new HashMap<>();
        map.put("A", new int[]{ 1, 4, 2});
        map.put("B", new int[]{ 11, 4, 21, 124});
        map.put("C", new int[]{ 1, 62});
        map.put("D", new int[]{ 120, 40});

        Set<String> keys = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (String key : keys) {
            int[] numbers = map.get(key);
            Arrays.sort(numbers);
            System.out.print(key + ": ");
            for (int number : numbers) {
                list.add(number);
                System.out.print(number + " ");
            }
            System.out.println();
        }

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();


        Integer maxSum = Integer.MIN_VALUE;
        List<Integer> arraySums = new ArrayList<>();
        for (String key : keys) {
            int sum = 0;
            for (int i : map.get(key)) {
                sum += i;
            }
            arraySums.add(sum);
            if(sum > maxSum) maxSum = sum;
        }
        System.out.println(maxSum);


        int i = 0;
        for (String key : keys) {
            if(arraySums.get(i++).equals(maxSum)) System.out.println(key);
        }

    }
}
