package task_6;

public class Promoter extends Employee{

    private int days;

    public Promoter(String name, int salary, int days){
        super(name, salary);
        this.days = days;
    }

    public int getSalaryForManager(){
        return (int)(0.01 * getDays() * getSalary());
    }



    public int getDays() {
        return days;
    }
}
