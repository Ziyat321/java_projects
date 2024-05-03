package generics;

import comparison.StringLengthCompare;

import java.util.Arrays;
import java.util.Comparator;

public class GenericSort {

    public static void main(String[] args) {
        Integer[] nums = {2, 5, 1, 77};
        sort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] words = new String[]{
                "liquid", "text", "template", "hi", "application"
        };

        sort(words, new StringLengthCompare());
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static <T> void sort(T[] arr, Comparator<T> comparator) {
        //Arrays.sort(arr, comparator);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(comparator.compare(arr[i], arr[j]) > 0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
