public class ArrayTask {

    public static void main(String[] args) {

        System.out.println(arrayEquals(new int[]{5,7,9},new int[]{5,7,9}));
        System.out.println(arrayEquals(new int[]{5,7,9},new int[]{5,9,7}));
        System.out.println(arrayEquals(new int[]{5,7,9},new int[]{5,7}));
    }

    private static boolean arrayEquals(int[] array1, int[] array2){
        if (array1.length == array2.length){
            for (int i = 0; i < array1.length; i++){
                if(array1[i] != array2[i]){
                  return false;
                }
            }
            return true;
        }
        return false;
    }

}
