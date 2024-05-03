package my_list;

import java.util.Arrays;
import java.util.Objects;

abstract public class MyAbstractList<T> implements MyList<T> {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MyList<?>)) return false;
        MyList<?> myList = (MyList<?>) obj;
        if (size() != myList.size()) return false;
        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(myList.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        T[] str = toArray();
        return Arrays.hashCode(str);
    }
}
