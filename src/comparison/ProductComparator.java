package comparison;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
        String category1 = o1.getCategory();
        String category2 = o2.getCategory();
        if (!category1.equals(category2)) return category1.compareTo(category2);
        return Integer.compare(o2.getPrice(), o1.getPrice());

    }
}
