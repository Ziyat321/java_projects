package task_6;

abstract public class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public int getSalaryForManager(){
        return 0;
    };

    public int getTotalSalary(){
        return getSalary();
    };

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
