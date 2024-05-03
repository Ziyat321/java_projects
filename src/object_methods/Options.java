package object_methods;

import java.util.Objects;

public class Options {

    private String char_ics1;
    private String char_ics2;

    public Options(String char_ics1, String char_ics2) {
        this.char_ics1 = char_ics1;
        this.char_ics2 = char_ics2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(char_ics1, char_ics2);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != Options.class) return false;
        Options option = (Options) obj;
        return (char_ics1.equals(option.char_ics1) && char_ics2.equals(option.char_ics2));
    }

    public void getInfo(){
        System.out.println("- " + getChar_ics1() + ": " + getChar_ics2());
    }

    public String getChar_ics1() {
        return char_ics1;
    }

    public String getChar_ics2() {
        return char_ics2;
    }
}
