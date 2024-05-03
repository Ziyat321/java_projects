package task_6;

public class Manager extends Employee{

    private Employee[] employees;

    public Manager(String name, int salary, Employee... employees){
        super(name, salary);
        this.employees = employees;
    }

    public int getTotalSalary(){
        int total = getSalary();
        for(Employee employee: employees){
            total += employee.getSalaryForManager();
        }
        return total;
    }

    public int avgSalaryOfSubordinates(){
        int avg = 0;
        if(employees.length != 0){
            for(Employee employee: employees){
                avg += employee.getTotalSalary();
            }
            return avg/ employees.length;
        }
        return 0;
    }

    public int avgTraderSummary(){
        int avg = 0;
        int totalOrders = 0;
        for(Employee employee: employees){
            if(employee instanceof Trader trader){
                avg += trader.getSummary();
                totalOrders += trader.getOrderCount();
            }
        }
        if(totalOrders != 0) return avg/totalOrders;
        return avg;
    }




    public Employee[] getEmployees() {
        return employees;
    }
}
