public class Main {
    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedList<>();

        for (int i = 1; i <= 10; i++) list.add(i);
        list.add(69, 0);

        System.out.println(list);
        System.out.println("Head: " + list.head());
        System.out.println("Tail: " + list.tail());
        System.out.println("Size: " + list.size());
        System.out.println("get(0): " + list.get(0));

        list.add(11, list.size());
        list.behead();
        list.cutTailOff();

        System.out.println("Removed idx 4: " + list.remove(4));
        System.out.println("Reverse: " + list.toStringReverse());

        MyQueue q = new MyQueue();
        for (int i = 1; i <= 10; i++) q.enqueue(i);
        System.out.println("Queue: " + q);
        q.dequeue(3);
        System.out.println("Queue after dequeue(3): " + q);
    }
}
