package generics;

import comparison.StringLengthCompare;

import java.util.Comparator;

public class GenericsMax {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{2 , 1, 11, 34, 12};
        System.out.println(maxValue(nums));

        String[] words = new String[]{
                "liquid", "text", "template", "hi", "application"
        };
        System.out.println(maxValue(words, new StringLengthCompare()));
    }

    public static <T extends Comparable<T>> T maxValue(T[] arr) {
        if (arr.length == 0) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("Массив пустой.");
            }
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) max = arr[i];
        }
        return max;
    }


    public static <T> T maxValue(T[] arr, Comparator<T> comparator){
        if (arr.length == 0) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("Массив пустой.");
            }
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i], max) > 0) max = arr[i];
        }
        return max;
    }

}
