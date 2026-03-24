public class MyQueue {
    private final MyDoubleLinkedList<Integer> queue = new MyDoubleLinkedList<>();

    public void enqueue(int x) {
        queue.add(x);
    }

    public int size() {
        return queue.size();
    }

    // BUG FIX: was calling get(0) then behead() separately — behead() already returns the removed node,
    // so we just need to handle the empty case cleanly.
    public int behead() {
        if (queue.size() == 0) throw new IndexOutOfBoundsException("Queue is empty!");
        return (int) queue.behead().data;
    }

    public int[] dequeue(int n) {
        if (n > queue.size()) throw new IndexOutOfBoundsException("Not enough elements in queue!");
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = (int) queue.behead().data;
        return result;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
