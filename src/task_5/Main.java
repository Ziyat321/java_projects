package task_5;

public class Main {

    public static void main(String[] args) {

        Fixed f = new Fixed();
        Special s = new Special();
        Extra e = new Extra();
        Fixed f1 = new Fixed();

       // System.out.println(f.equals(f1));

        Order o1 = new Order(120_000, new Discount[]{f,f,f, f1});
        Order o2 = new Order(260_000, new Discount[]{s,e, f});
        Order o3 = new Order(500_000, new Discount[] {s});

        /*System.out.println(o1.getTotalWithDiscounts());
        System.out.println(o2.getTotalWithDiscounts());*/

        Order[] orders = new Order[]{o1,o2,o3};

        for(Order order: orders){
            for(Discount discount: order.getDiscounts()){
                if(discount.equals(f)){
                    System.out.println(order.getTotalWithDiscounts());
                    break;
                }
            }
        }


    }
}
