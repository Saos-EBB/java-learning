public class MyDoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    // --- Add ---

    public void add(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(T e, int idx) {
        if (idx < 0 || idx > size) throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
        if (head == null || idx == size) {
            add(e);
            return;
        }
        Node<T> newNode = new Node<>(e);
        if (idx == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < idx - 1; i++) current = current.next;
        newNode.next = current.next;
        if (current.next != null) current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
        if (newNode.next == null) tail = newNode;
        size++;
    }

    // --- Get ---

    public int size() {
        return size;
    }

    public Node<T> head() {
        return head;
    }

    // BUG FIX: was traversing from head instead of returning tail field directly
    public Node<T> tail() {
        return tail;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
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

    // --- Remove ---

    public Node<T> behead() {
        if (head == null) return null;
        Node<T> removed = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
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
            head = null;
        }
        size--;
        return removed;
    }

    public Node<T> remove(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
        if (idx == 0) return behead();
        if (idx == size - 1) return cutTailOff();
        Node<T> current = searchNode(idx);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current;
    }

    private Node<T> searchNode(int idx) {
        Node<T> current;
        if (idx < size / 2) {
            current = head;
            for (int i = 0; i < idx; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > idx; i--) current = current.prev;
        }
        return current;
    }

    // --- toString ---

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringReverse() {
        if (tail == null) return "[]";
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
}
