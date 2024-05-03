package task_4;

public class Main {

    public static void main(String[] args) {

        Simplified simplified = new Simplified();
        Common common = new Common();
        Patent patent = new Patent();

        Company runtime = new Company("Runtime", 2_400_000, simplified);
        Company arta = new Company("Arta", 90_000_000, common);
        Company john = new Company("John", 7_500_000, patent);
        Company mark = new Company("Mark", 120_000_000, common);

        Company[] companies = new Company[]{runtime, arta, john, mark};

        for(Company company: companies){
            System.out.println(company.getName());
            System.out.println("- Сумма после вычета ИПН: " + company.getAmountAfterTax());
            System.out.println("- Размер ИПН: " + company.getTaxAmount());
            System.out.println();
        }

        int maxTax = 0;
        Company c = null;
        for(Company company: companies){
            if(company.getTaxAmount() > maxTax) {
                maxTax = company.getTaxAmount();
                c = company;
            }
        }

        System.out.println("Больше всего налогов уплатила компания " + c.getName());
        System.out.println("Количество уплаченных налогов: " + c.getTaxAmount());

        maxTax = 0;
        for(Company company: companies){
            if(company.getTax() instanceof Common && company.getTaxAmount() > maxTax){
                maxTax = company.getTaxAmount();
                c = company;
            }
        }

        System.out.println("По общему виду налогу больше всего оплатила компания " + c.getName());
        System.out.println("Количество уплаченных налогов: " + c.getTaxAmount());

    }
}
