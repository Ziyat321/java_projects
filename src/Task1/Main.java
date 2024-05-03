package Task1;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Ainur",5);
        Person p2 = new Person("Arman", 22);
        Person p3 = new Person("John", 43);

//        City c1 = new City("Astana", new Person[]{p1,p2,p3} );
        //City c1 = new City("Astana", new Person[]{});
        City c1 = new City("Astana");


        int adult_number = c1.adult_number();
        System.out.println("Количество совершеннолетних людей в городе " + c1.getName() + ": " + adult_number);

        double avg_adult_age = c1.avg_adult_age();
        System.out.println("Средний возраст совершеннолетних людей: " + avg_adult_age);

    }

}
