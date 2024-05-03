public class Var {

    public static void main(String[] args) {

        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';

        char temp = a;
        a = b;
        b = c;
        c = d;
        d = temp;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
