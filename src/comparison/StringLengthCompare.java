package comparison;

import java.util.Comparator;

public class StringLengthCompare implements Comparator<String> {


    @Override
    public int compare(String str1, String str2) {
        return Integer.compare(str1.length(), str2.length());
    }
}
