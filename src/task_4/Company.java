package task_4;

public class Company {

    private String name;
    private int income;
    private Tax tax;

    Company(String name, int income, Tax tax){
        this.name = name;
        this.income = income;
        this.tax = tax;
    }

    public int getAmountAfterTax(){
        return income - getTaxAmount();
    }

    public int getTaxAmount(){
        return (int)(income * (double)tax.getTAX()/100);
    }

    public String getName() {
        return name;
    }

    public int getIncome() {
        return income;
    }

    public Tax getTax() {
        return tax;
    }
}
