package task_7;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private List<Contact> contacts;

    public Phonebook(){
        contacts = new ArrayList<>();
    }


    public void addContact(Contact contact){

        if(!contacts.contains(contact)) contacts.add(contact);

    }

    public List<Contact> searchContacts(String numberPart) {
        List<Contact> list = new ArrayList<>();
        for(Contact c: contacts){
            if(c.getNumber().contains(numberPart)) list.add(c);
        }
        if(list.size()!=0) return list;
        throw new ContactsNotFoundException("Контакт не найден");
    }

    public int searchContactsByGroup(String group){
        int count = 0;
        for(Contact c: contacts){
            if(c.getGroup().equals(group)) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        String str = "";
        for(Contact c: contacts){
            str += c.toString() + "\n";
        }
        return str;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
