package map_tasks;

import java.util.*;

public class MapTask5 {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone 12", 200_000, "Smartphone");
        Product p2 = new Product("iPhone 13", 400_000, "Smartphone");
        Product p3 = new Product("Toyota Camry 6", 7_000_000, "Car");
        Product p4 = new Product("Lexus LX570", 15_000_000, "Car");
        Product p5 = new Product("Cadillac Escalade", 20_000_000, "Car");

        Product[] products = new Product[]{p1, p2, p3, p4, p5};

        //Map<String, Integer[]> categoryAvg = new HashMap<>();

       /* for(Product product: products){
            String category = product.getCategory();

            if(!categoryAvg.containsKey(category)){
                Integer[] sum_count = new Integer[2];
                sum_count[0] = product.getPrice();
                sum_count[1] = 1;
                categoryAvg.put(category, sum_count);
            } else {
                Integer[] sum_count = categoryAvg.get(category);
                sum_count[0] += product.getPrice();
                sum_count[1]++;
            }
        }*/



     /*   Set<String> keys = categoryAvg.keySet();
        for(String key:keys){
            Integer[] sum_count = categoryAvg.get(key);
            int avg = sum_count[0]/sum_count[1];
            System.out.println(key + "'s average price = " + avg);
        }


*/
        Map<String, List<Product>> categoryAvg = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            if (!categoryAvg.containsKey(category)) {
                List<Product> list = new ArrayList<>();
                list.add(product);
                categoryAvg.put(category, list);
            } else {
                List<Product> list = categoryAvg.get(category);
                list.add(product);
            }
        }

        Set<String> keys = categoryAvg.keySet();
        for(String key:keys){
            List<Product> list = categoryAvg.get(key);
            int sum = 0;
            for(Product product: list){
                sum += product.getPrice();
            }
            int avg = sum/ list.size();
            System.out.println(key + "'s average price = " + avg);
        }


    }
}
