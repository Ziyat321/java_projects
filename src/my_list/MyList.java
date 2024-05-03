package my_list;

import java.util.Comparator;

public interface MyList<T> {

    void add(T value);

    void add(int position, T value);

    T get(int position);

    void set(int position, T value);

    void remove(int position);

    boolean contains(T value);

    int indexOf(T value);

    int lastIndexOf(T value);

    void sort(Comparator<T> comparator);

    int size();

    T[] toArray();
}
