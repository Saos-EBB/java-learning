package LinkedLists.src;

public class MyQueue {
    MyDoubleLinkedList<Integer> Queue = new MyDoubleLinkedList<>();

    public void enqueue(int x) {
        Queue.add(x, Queue.size());
    }

    public int size() {
        return Queue.size();
    }

    public int behead() {
        int temp = Queue.get(0);
        Queue.behead();
        return temp;
    }

    public int[] dequeue(int n) {
        int[] dq = new int[n];
        for (int i = 0; i < n; i++) {
            dq[i] = Queue.get(0);
            Queue.behead();
        }

        return dq;
    }

    @Override
    public String toString() {
        return Queue.toString();
    }


}






