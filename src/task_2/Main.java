package task_2;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone X", 1000, true);

        Product p2 = new Product("iPhone 13", 1500);
        p2.setAvailable(false);

        Product p3 = new Product("iPhone 14", 2500, true);
        Order o1 = new Order(10,new Product[]{p1,p2,p3});

        System.out.println("Общая стоимость заказа с учетом скидки - " + o1.cost() + " $.");

    }
}
