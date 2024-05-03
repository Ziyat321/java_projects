package classes;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product();
        p1.name = "Хлеб";
        p1.price = 150;
        p1.count = 5;

        p1.sell(6);

    }

}
