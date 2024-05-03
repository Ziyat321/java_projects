package Task1;

public class City {

    private String name;
    private Person[] people;


    public City(String name){
        this.name = name;
    }

    public City(String name, Person[] people){
        this.name = name;
        this.people = people;
    }

    public int adult_number(){
        if(people == null || people.length == 0){
            return 0;
        }
        else{
            int count = 0;
            for(int i = 0; i < people.length; i++){
                if(people[i].getAge() >= 18) count++;
            }
            return count;
        }

    }

    public double avg_adult_age(){
        if(people == null || people.length == 0){
            return 0;
        }
        else{
            int adult_number = this.adult_number();
            int total = 0;
            for(int i = 0; i < people.length; i++){
                if(people[i].getAge() >= 18) total += people[i].getAge();
            }
            return (double) total/adult_number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }



}
