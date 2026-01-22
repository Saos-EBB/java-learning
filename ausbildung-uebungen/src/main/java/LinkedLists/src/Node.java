package LinkedLists.src;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    //Konstruktor -> null
    Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    //Konstruktor -> next zuweisen
    Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    //toString
    @Override
    public String toString() {
        return data.toString();
    }

    //Next exist ?
    public boolean hasNext() {
        return next != null;
    }
}