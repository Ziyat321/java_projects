package task_3;

public class Intern extends Employee{

    private final int days;

    public Intern(String name, int salary, int days){
        super(name, salary);
        this.days = days;
    }



    public int getDays() {
        return days;
    }
}
