package map_tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTask4 {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone 12", 200_000, "Smartphone");
        Product p2 = new Product("iPhone 13", 400_000, "Smartphone");
        Product p3 = new Product("Toyota Camry 6", 7_000_000, "Car");
        Product p4 = new Product("Lexus LX570", 15_000_000, "Car");
        Product p5 = new Product("Cadillac Escalade", 20_000_000, "Car");

        Product[] products = new Product[]{p1,p2,p3,p4,p5};

        Map<String, List<String>> categoryList = new HashMap<>();

       /* for(Product product: products){
            String category = product.getCategory();
            if(!categoryList.containsKey(category)){
                List<String> list = new ArrayList<>();
                for(Product p: products){
                    if(p.getCategory().equals(category)){
                        list.add(p.getName());
                    }
                }
                categoryList.put(category, list);
            }
        }*/

        for(Product product: products){
            String category = product.getCategory();

            if(!categoryList.containsKey(category)){
                List<String> list = new ArrayList<>();
                list.add(product.getName());
                categoryList.put(category, list);
            } else {
                List<String> list = categoryList.get(category);
                list.add(product.getName());
            }
        }



        System.out.println(categoryList);

    }
}
