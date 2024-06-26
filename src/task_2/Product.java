package task_2;

public class Product {

    private String name;
    private int price;
    private boolean available;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price, boolean available){
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
