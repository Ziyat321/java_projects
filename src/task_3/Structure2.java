package task_3;

public class Structure2 {

    public static void main(String[] args) {

     /*   Manager m1 = new Manager("John", 1_200, 900);
        Worker w1 = new Worker("Mark", 1_400, 800);
        Worker w2 = new Worker("Bill", 1_600, 400);
        Intern i1 = new Intern("Max", 700, 70);
        Manager m2 = new Manager("Jax", 3_000, 1_000, m1, w1, w2, i1);*/

        /*System.out.println(m2.avgSalary());
        System.out.println(m2.richEmployee().getName());*/


        Manager bill = new Manager("Bill", 1_100, 600, new Employee[]{
                new Manager("Jeff", 850, 250, new Employee[]{
                        new Manager("Alex", 1_000, 200, new Employee[]{
                                new Intern("John", 300, 50)
                        }),
                        new Intern("Nick", 220, 30)
                }),
                new Worker("Mick", 500, 120),
                new Worker("Max", 600, 100)
        });

        System.out.println(bill.getAllEmployeesTotalSalary());
    }

}
