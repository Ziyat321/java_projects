package task_3;

public class Employee {

    private final String name;
    private final int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getTotalSalary(){
        return getSalary();
    }

    public int getAllEmployeesTotalSalary(){
        return getSalary();
    }


 /*   public int employeeSalary() {
        int salary = 0;
        salary += this.getSalary();
        if (this instanceof Worker w) {
            salary += w.getBonus();
        }
        return salary;
    }*/

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
