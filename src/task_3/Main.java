package task_3;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Jeff", 1_200);
        Manager m1 = new Manager("Leon", 2_200, 1_100);
        Worker w1 = new Worker("Mark", 1_400, 800);
        Worker w2 = new Worker("Bill", 1_600, 400);
        Intern i1 = new Intern("Max", 700, 70);


        Employee[] employees = new Employee[]{e1, m1, w1, w2, i1};

        for (Employee employee : employees) {
            /*System.out.print(employee.getName() + ": ");
            int salary = employee.getSalary();
            if (employee instanceof Manager manager) {
                int total = (int)(1.15 * (salary + manager.getBonus()));
                System.out.println(total);
            } else if (employee instanceof Worker worker) {
                System.out.println((salary + worker.getBonus()));
            } else {
                System.out.println(salary);
            }*/

            System.out.println(employee.getName() + ": " + employee.getSalary());
        }


    }
}
