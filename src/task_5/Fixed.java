package task_5;

public class Fixed extends Discount{

    public int getDiscountAmount(int amount){
        return (int) (0.04 * amount);
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != Fixed.class) return false;
        return true;
    }*/

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
