public class Cycles {

    public static void main(String[] args) {

        for (int i = 77; i < 80; i++){
            //System.out.println(i);
        }

        for (int i = -25; i > -28; i--){
            //System.out.println(i);
        }

        for (int i = 100; i < 350; i+=100){
            //System.out.println(i);
        }

        for (int i = 999; i > 994; i-=2){
            //System.out.println(i);
        }


        for (int i = 2 ; i < 11; i++){
            //System.out.println(i + " * " + i + " = " + i*i);
        }

        int sum = 0;
        for (int i = 1; i < 21; i++){
            sum+=i;
        }
       //System.out.println(sum);

        int start = 5;
        int end = 10;

        if (start < end){
            for (int i = start; i <= end; i++){
                //System.out.print(i + " ");
            }
            //System.out.println();
        } else if(start > end){
            for (int i = start; i >= end; i--){
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println(start);
        }

        int n1 = 2;
        int n2 = 3;

        System.out.print(n1 + " " + n2 + " ");
        int sum1 = n1 + n2;

        for (int i = 2; i < 20; i++){
            System.out.print(sum1 + " ");
//            int temp = sum1;
//            sum1 += n2;
//            n2 = temp;
            n1 = n2;
            n2 = sum1;
            sum1 = n1 + n2;
        }
        System.out.println();




    }
}
