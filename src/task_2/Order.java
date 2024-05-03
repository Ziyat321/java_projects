package task_2;

public class Order {

    private int discount;
    private Product[] products;

    public Order(int discount, Product[] products){
        this.discount = discount;
        this.products = products;
    }


    public double cost(){
        double total_cost = 0;
        for(Product x: products){
            if(x.isAvailable()){
                total_cost += x.getPrice();
            }
        }
        total_cost *=  (double)(100 - discount) / 100;
        return total_cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
