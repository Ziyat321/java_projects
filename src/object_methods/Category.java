package object_methods;

public class Category {

    private String category;

    @Override
    public int hashCode() {
        return category.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != Category.class) return false;
        Category c = (Category) obj;
        return (category.equals(c.category));
    }

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
