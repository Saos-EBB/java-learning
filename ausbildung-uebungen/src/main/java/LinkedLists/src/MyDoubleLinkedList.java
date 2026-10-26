package LinkedLists.src;

public class MyDoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    //add stuff
    public void add(T e) {
        Node<T> newNode = new Node<>(e);
        //Liste leer
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        //Liste !leer
        Node<T> current = head;
        while (current.next != null) current = current.next;
        // neuen Node anhängen
        current.next = newNode;
        newNode.prev = current;
        tail = newNode;
        size++;
    }

    public void add(T e, int idx) {
        if (idx > size || idx < 0) throw new IndexOutOfBoundsException("idx > size || idx < 0 = wrong");
        Node<T> newNode = new Node<>(e);
        //Liste leer
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        //add vorne
        if (idx == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        //Liste !leer
        Node<T> current = head;
        for (int i = 0; i < idx - 1; i++) current = current.next;
        //neuen Node einfügen
        newNode.next = current.next;
        if (current.next != null) current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
        //add hinten -> tail aktualisieren
        if (newNode.next == null) tail = newNode;
        size++;
    }
    // get stuff
    public int size() {
        return size;
    }

    public Node<T> head() {
        if (head == null) return null;
        return head;
    }

    public Node<T> tail() {
        if (head == null) return null;
        Node<T> current = head;
        while (current.next != null) current = current.next;
        return current;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
        Node<T> current;
        if (idx < size / 2) {
            current = head;
            for (int i = 0; i < idx; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > idx; i--) current = current.prev;
        }
        return current.data;
    }

    // cutting limbs of
    public Node<T> behead() {
        if (head == null) return null;
        Node<T> removed = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // Liste wurde leer
        }
        size--;
        return removed;
    }

    public Node<T> cutTailOff() {
        if (tail == null) return null;
        Node<T> removed = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // Liste wurde leer
        }
        size--;
        return removed;
    }

    public Node<T> remove(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
        if (idx == 0) return behead();
        if (idx == size - 1) return cutTailOff();

        Node<T> current = searchNode(idx);

        // current ist der zu entfernende Node
        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
        return current;
    }

    private Node<T> searchNode(int idx) {
        Node<T> current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current;
    }


    //toString
    public String toStringReverse() {
        if (tail == null) return "Leer.";

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = tail;

        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) sb.append(", ");
            current = current.prev;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        //Liste leer
        if (head == null) return "Leer.";
        //Liste !leer
        while (current != null) {
            sb.append(", ").append(current.data);
            current = current.next;
        }
        sb.delete(1, 3);
        sb.append("]");
        return sb.toString();
    }


}
