package map_tasks;

import java.util.HashMap;
import java.util.Map;

public class MapTask3 {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone 12", 200_000, "Smartphone");
        Product p2 = new Product("iPhone 13", 400_000, "Smartphone");
        Product p3 = new Product("Toyota Camry 6", 7_000_000, "Car");
        Product p4 = new Product("Lexus LX570", 15_000_000, "Car");
        Product p5 = new Product("Cadillac Escalade", 20_000_000, "Car");

        Product[] products = new Product[]{p1,p2,p3,p4,p5};

        Map<String, Integer> categoryCount = new HashMap<>();

        for(Product product:products){
            String category = product.getCategory();
            if(!categoryCount.containsKey(category)){
                categoryCount.put(category, 1);
            } else {
                categoryCount.put(category, categoryCount.get(category) + 1);
            }
        }

        System.out.println(categoryCount);

    }

}
