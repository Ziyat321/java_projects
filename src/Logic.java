public class Logic {

    public static void main(String[] args) {

        int num = 44;
        boolean res = !(num >= 35 && num <=75);
        boolean res1 = num < 35 || num > 75;
        //System.out.println(res1);

        int num1 = 320;
        boolean res2 = num1 >= -500 && num1 <= -100 || num1 >= 100 && num1 <= 500;
        //System.out.println(res2);

        int n1 = 50;
        int n2 = 60;
        int n3 = 40;
        boolean res3 = n1 + n2 + n3 == 150;
        //System.out.println(res3);
        boolean res4 = n1 == 50 && n2 == 50 && n3 == 50;
        //System.out.println(res4);
        boolean res5 = (n1 == 50 || n2 == 50 || n3 == 50) && n1 + n2 + n3 == 150;
        //System.out.println(res5);


    }
}
