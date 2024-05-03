package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySameElements {

    public static void main(String[] args) {

        Integer[] nums1 = {3, 4, 5, 8, 4};
        Integer[] nums2 = {3 ,4, 7, 4, 5};
        Integer[] nums3 = sameElements(nums1, nums2);
        System.out.println(Arrays.toString(nums3));

    }


    @SuppressWarnings("unchecked")
    private static <T> T[] sameElements(T[] first, T[] second){
        int identicalCounter = 0;
        Class<?> arrayItemType = first.getClass().componentType();

        T[] firstCopy = first;
        T[] secondCopy = second;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(first[i].equals(second[j])){
                    identicalCounter++;
                    //T[] temp1 = (T[]) Array.newInstance(arrayItemType, first.length - 1);
                    int pos = 0;
                   /* for (int k = 0; k < i; k++) {
                        temp1[pos++] = first[k];
                    }
                    for (int k = i + 1; k < first.length; k++) {
                        temp1[pos++] = first[k];
                    }
                    first = temp1;*/
                    //pos = 0;
                    T[] temp2 = (T[]) Array.newInstance(arrayItemType, second.length - 1);
                    for (int k = 0; k < j; k++) {
                        temp2[pos++] = second[k];
                    }
                    for (int k = j + 1; k < second.length; k++) {
                        temp2[pos++] = second[k];
                    }
                    second = temp2;
                    //pos = 0;
                    //i--;
                    break;
                }
            }
        }

        first = firstCopy;
        second = secondCopy;
        T[] newArray = (T[]) Array.newInstance(arrayItemType, identicalCounter);
        int pos = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(first[i].equals(second[j])){
                    newArray[pos++] = first[i];
                    //T[] temp1 = (T[]) Array.newInstance(arrayItemType, first.length - 1);
                    int pos1 = 0;
                    /*for (int k = 0; k < i; k++) {
                        temp1[pos1++] = first[k];
                    }
                    for (int k = i + 1; k < first.length; k++) {
                        temp1[pos1++] = first[k];
                    }
                    first = temp1;*/
                    //pos1 = 0;
                    T[] temp2 = (T[]) Array.newInstance(arrayItemType, second.length - 1);
                    for (int k = 0; k < j; k++) {
                        temp2[pos1++] = second[k];
                    }
                    for (int k = j + 1; k < second.length; k++) {
                        temp2[pos1++] = second[k];
                    }
                    second = temp2;
                    //pos1 = 0;
                    //i--;
                    break;
                }
            }
        }
        return newArray;
    }
}
