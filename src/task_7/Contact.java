package task_7;

import java.util.Objects;

public class Contact {

    private String name;
    private String number;
    private String group;

    public Contact(String name, String number, String group) {
        this.name = name;
        this.number = number;
        this.group = group;
    }

    @Override
    public String toString() {
        String str = name;
        if(name.length() < 4) {
            str += "\t\t";
        } else str += "\t";
        str += number + "\t\t" + group;
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(number, contact.number) && Objects.equals(group, contact.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, group);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getGroup() {
        return group;
    }
}
