package comparison;

import java.util.Comparator;
import java.util.Map;

public class CitiesComparator implements Comparator<String> {

    private Map<String, Integer> cities;

    public CitiesComparator(Map<String, Integer> cities) {
        this.cities = cities;
    }

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(cities.get(o2), cities.get(o1));
    }
}
