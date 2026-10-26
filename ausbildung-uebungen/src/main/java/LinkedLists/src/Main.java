import LinkedLists.src.*;

void main() {
    MyDoubleLinkedList<Integer> intList = new MyDoubleLinkedList<>();

    for (int i = 0; i < 10; i++) intList.add(i + 1);
    intList.add(69, 0);
    IO.println(intList.toString());
    IO.println(intList.head());
    IO.println(intList.tail());
    IO.println(intList.size());
    IO.println(intList.get(0));
    intList.add(11, intList.size());
    intList.behead();
    intList.cutTailOff();
    IO.println(intList.remove(4));
    IO.println(intList.toStringReverse());

    MyQueue Q = new MyQueue();
    for (int i = 1; i < 11 ; i++)Q.enqueue(i);
    System.out.println("Q: " +Q);
    Q.dequeue(3);
    System.out.println("Q: " +Q);


}
