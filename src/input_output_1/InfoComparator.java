package input_output_1;

import java.util.Comparator;

public class InfoComparator implements Comparator<String[]> {

    @Override
    public int compare(String[] o1, String[] o2) {
        return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
    }
}
