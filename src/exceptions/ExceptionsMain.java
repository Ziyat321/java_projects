package exceptions;

public class ExceptionsMain {


    public static void main(String[] args) {


        System.out.println(average(new int[]{11,15,19}));
        System.out.println(average(new int[]{}));
        System.out.println(average(new int[]{5,15}));

    }


    private static int average(int[] array){
        int sum = 0;

        for (int i : array) {
            sum += i;
        }

        try{
            return sum/array.length;
        } catch(ArithmeticException e){
            System.out.print("Пустой массив: ");
        }
        return 0;

    }

}
