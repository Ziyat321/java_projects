package task_6;

public class Trader extends Employee{

    private int summary;
    private int orderCount;

    public Trader(String name, int salary, int summary, int orderCount){
        super(name, salary);
        this.summary = summary;
        this.orderCount = orderCount;
    }

    public int getSalaryForManager(){
        return (int)(0.15 * getSummary());
    }

    @Override
    public int getTotalSalary() {
        return getSalary() + (int)(0.1 * getSummary());
    }

    public int getSummary() {
        return summary;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
