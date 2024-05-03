package my_list;

import java.util.Comparator;

public class MyLinkedList<T> extends MyAbstractList<T> {

    private Node<T> first;

    private Node<T> last;

    private int size;

    MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            Node<T> n = new Node<T>(null, null, value);
            first = n;
            last = n;
        } else {
            Node<T> n = new Node<T>(last, null, value);
            last.setNext(n);
            last = n;
        }
        size++;
    }

    @Override
    public void add(int position, T value) {
        if (position < 0 || position > size) return;
        Node<T> n = new Node<T>(null, null, value);
        if (position == 0) {
            n.setNext(first);
            first.setPrev(n);
            first = n;
        } else if (position == size) {
            n.setPrev(last);
            last.setNext(n);
            last = n;
        } else {
            Node<T> p = getNodeByIndex(position);
            n.setPrev(p.getPrev());
            n.setNext(p);
            p.getPrev().setNext(n);
            p.setPrev(n);
        }
        size++;
    }

    @Override
    public T get(int position) {
        try {
            if (position < 0 || position >= size) throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вышли за пределы массива.");
        }
        Node<T> n = getNodeByIndex(position);
        return n.getValue();
    }

    @Override
    public void set(int position, T value) {
        try {
            if (position < 0 || position >= size) throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вышли за пределы массива.");
        }
        Node<T> n = getNodeByIndex(position);
        n.setValue(value);
    }

    @Override
    public void remove(int position) {
        try {
            if (position < 0 || position >= size) throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вышли за пределы массива.");
        }
        if (position == 0) {
            first = first.getNext();
            first.setPrev(null);
        } else if (position == size - 1) {
            last = last.getPrev();
            last.setNext(null);
        } else {
            Node<T> n = getNodeByIndex(position);
            Node<T> prev = n.getPrev();
            Node<T> next = n.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }
        size--;
    }

    @Override
    public boolean contains(T value) {
        Node<T> n = first;
        for (int i = 0; i < size; i++) {
            if (n.getValue().equals(value)) return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node<T> n = first;
        for (int i = 0; i < size; i++) {
            if (n.getValue().equals(value)) return i;
            n = n.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node<T> n = last;
        for (int i = size - 1; i >= 0; i--) {
            if (n.getValue().equals(value)) return i;
            n = n.getPrev();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Node<T> n = last;
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                if (comparator.compare(n.getValue(), n.getPrev().getValue()) < 0) {
                    T temp = n.getValue();
                    n.setValue(n.getPrev().getValue());
                    n.getPrev().setValue(temp);
                }
                n = n.getPrev();
            }
            n = last;
        }
    }

    private Node<T> getNodeByIndex(int position) {
        //if (position < 0 || position >= size) return null;
        Node<T> n;
        if (position >= 0 && position <= size / 2) {
            n = first;
            for (int i = 0; i < position; i++) {
                n = n.getNext();
            }

        } else {
            n = last;
            for (int i = size - 1; i > position; i--) {
                n = n.getPrev();
            }

        }
        return n;

    }

    @Override
    public String toString() {
        String str = "[";
        Node<T> n = first;
        do {
            if (n == last) str += n.getValue() + "]";
            else str += n.getValue() + ", ";
            n = n.getNext();
        } while (n != null);
        return str;
    }

    @Override
    public T[] toArray() {
        Object[] values = new Object[size];
        Node<T> n = first;
        for (int i = 0; i < size; i++) {
            values[i] = n.getValue();
            n = n.getNext();
        }
        return (T[]) values;
    }
}
