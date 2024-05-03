package task_3;

public class Manager extends Worker {

    Employee[] employees;

    public Manager(String name, int salary, int bonus, Employee... employees) {
        super(name, salary, bonus);
        this.employees = employees;
    }

    public int getTotalSalary(){
        return (int)(super.getTotalSalary() * 1.15);
    }

    public int getAllEmployeesTotalSalary(){
        int total = getSalary();
        for(Employee employee: employees){
            total += employee.getAllEmployeesTotalSalary();
        }
        return total;
    }


    public int avgSalary() {
        int avgSal = 0;
        int count = 0;

        for (Employee x : employees) {
            if (!(x instanceof Manager)) {
                avgSal += x.getTotalSalary();
                count++;
            }
        }
        return avgSal / count;
    }

    public Employee richEmployee() {
        int maxSal = 0;
        int total = 0;
        Employee rich = null;
        for (Employee x : employees) {
            if (!(x instanceof Manager)) {
                total += x.getTotalSalary();
            }
            if (total > maxSal) {
                maxSal = total;
                rich = x;
            }
            total = 0;
        }
        return rich;
    }


    public Employee[] getEmployees() {
        return employees;
    }


}
