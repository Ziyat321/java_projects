package task_6;

public class Main {

    public static void main(String[] args) {

        Manager bill = new Manager("Bill", 220_000, new Employee[]{
                new Trader("Mark", 170_000, 900_000, 18),
                new Trader("John", 160_000, 820_000, 12),
                new Promoter("Max", 150_000, 30)
        });

        System.out.println(bill.getTotalSalary());
        System.out.println(bill.avgSalaryOfSubordinates());
        System.out.println(bill.avgTraderSummary());

    }

}
