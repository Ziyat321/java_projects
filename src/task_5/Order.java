package task_5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private int cost;
    private Set<Discount> discounts;

    public Order(int cost, Discount... discounts){
        this.cost = cost;
        this.discounts = new HashSet<>();
        Collections.addAll(this.discounts, discounts);
    }

    public int getTotalWithDiscounts(){
        int total = 0;
        for(Discount discount: discounts){
            total += discount.getDiscountAmount(cost);
        }
        int twelveDiscount = cost * 88 / 100;
        int totalDiscount = cost - total;
        if(twelveDiscount > totalDiscount) return twelveDiscount;
        return totalDiscount;
    }

    public int getCost() {
        return cost;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }
}
