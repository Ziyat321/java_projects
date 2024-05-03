package my_list;

public class Node<T> {

    private Node<T> prev;

    private Node<T> next;

    private T value;

    public Node(Node<T> prev, Node<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
