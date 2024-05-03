package comparison;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        Product p1 = new Product("Смартфоны", "Apple iPhone 12", 459_000);
        Product p2 = new Product("Ноутбуки", "Apple MacBook Air", 569_000);
        Product p3 = new Product("Смартфоны", "Samsung Galaxy S22", 329_000);
        Product p4 = new Product("Наушники", "Samsung Galaxy Buds 2", 117_000);

        Product[] products = new Product[]{p1, p2, p3, p4};

        Arrays.sort(products, new ProductComparator());
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();

    }

}
