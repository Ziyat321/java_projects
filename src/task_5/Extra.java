package task_5;

public class Extra extends Discount{

    public int getDiscountAmount(int amount){
        int discount;
        if(amount > 200_000){
            return (int) (0.07 * amount);
        } else if (amount > 150_000){
            return (int) (0.05 * amount);
        } else if (amount > 100_000){
            return (int) (0.03 * amount);
        } else return 0;
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != Extra.class) return false;
        return true;
    }*/

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
