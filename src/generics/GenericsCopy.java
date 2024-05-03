package generics;

import java.lang.reflect.Array;

public class GenericsCopy {

    public static void main(String[] args) {

        String[] words = new String[]{
                "liquid", "text", "template", "hi", "application"
        };

        String[] wordsCopy = copy(words);

        System.out.println(wordsCopy[0]);

    }


    @SuppressWarnings("unchecked")
    public static<T> T[] copy(T[] array){
        Class<?> arrayItemType = array.getClass().componentType();
        T[] arrayCopy = (T[]) Array.newInstance(arrayItemType, array.length);
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }

        return arrayCopy;

    }

}
