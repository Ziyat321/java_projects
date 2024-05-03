package task_7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.addContact(new Contact("Bill","8-701-097-87-67","Friends"));
        phonebook.addContact(new Contact("Max","8-702-294-85-65","Family"));
        phonebook.addContact(new Contact("Bill","8-701-097-87-67","Friends"));
        phonebook.addContact(new Contact("Jack","8-775-044-81-23","Friends"));
        phonebook.addContact(new Contact("John","8-701-434-00-32","Work"));

        System.out.println(phonebook);

        try{
            List<Contact> checkList = phonebook.searchContacts("-701");

            System.out.println(checkList);
        } catch (ContactsNotFoundException e){
            System.out.println(e);
        }

        System.out.println("\n" + phonebook.searchContactsByGroup("Friends"));


    }

}

