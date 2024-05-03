package task_5;

public class Special extends Discount{

    public int getDiscountAmount(int amount){
        int discount = amount > 250_000 ? (int)(0.06 * amount) : 0;
        return discount;
    }

    /*@Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != Special.class) return false;
        return true;
    }*/

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
