package object_methods;

public class Main {

    public static void main(String[] args) {

        /*Product p1 = new Product(new Category("Smartphones"), "Apple IPhone 12", 990);
        Product p2 = new Product(new Category("Smartphones"), "Apple IPhone 12", 990);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());*/

        Product p1 = new Product(new Category("Smartphones"), "Apple IPhone 12", 990,
                new Options[]{new Options("Producer", "Apple"), new Options("Diagonal", "6.2")});
        Product p2 = new Product(new Category("Computer"), "HP", 4_000,
                new Options[]{new Options("Producer", "HP"), new Options("Diagonal", "17")});

        Product[] products = new Product[]{p1, p2};

        /*for (Product product : products) {
            product.getInfo();
            System.out.println("\n");
        }*/

        for(Product product: products) {
            if (product.checkOption("Producer", "Apple")) {
                product.getInfo();
                System.out.println("\n");
            }
        }

        }

    }

