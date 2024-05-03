package object_methods;

import java.util.Arrays;
import java.util.Objects;

public class Product {

    private Category category;
    private String name;
    private int price;
    private Options[] options;

    public Product(Category category, String name, int price, Options... options) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.options = options;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price, Arrays.hashCode(options));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != Product.class) return false;
        Product product = (Product) obj;
        return (this.category.equals(product.category) && this.name.equals(product.name)
                && this.price == product.price && Arrays.equals(options, product.options));
    }

    public void getInfo() {
        System.out.println("Категория: " + category.getCategory());
        System.out.println("Название: " + getName());
        System.out.println("Стоимость: " + getPrice());
        for (Options option : getOptions()) {
            option.getInfo();
        }
    }

    public boolean checkOption(String str1, String str2) {
        for (Options option : getOptions()) {
            if (option.getChar_ics1().equals(str1) && option.getChar_ics2().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Options[] getOptions() {
        return options;
    }
}
