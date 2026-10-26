[README.md](https://github.com/user-attachments/files/26226177/README.md)
# 🔗 Doubly Linked List

Generische doppelt verkettete Liste in Java – mit einer Queue die darauf aufbaut.

## Dateien

| Datei | Beschreibung |
|---|---|
| `Node.java` | Generischer Knoten mit `data`, `next`, `prev` |
| `MyDoubleLinkedList.java` | Doppelt verkettete Liste (generisch) |
| `MyQueue.java` | Integer-Queue, basiert auf `MyDoubleLinkedList` |
| `MyQueueTest.java` | JUnit 5 Tests für `MyQueue` |
| `Main.java` | Demo / Einstiegspunkt |

## Quickstart

```bash
javac *.java
java Main
```

## Beispielausgabe

```
[69, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Head: 69
Tail: 10
Size: 11
Removed idx 4: 4
Reverse: [9, 8, 7, 6, 5, 3, 2, 1]
Queue: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Queue after dequeue(3): [4, 5, 6, 7, 8, 9, 10]
```

## MyDoubleLinkedList

```java
MyDoubleLinkedList<Integer> list = new MyDoubleLinkedList<>();
list.add(42);           // ans Ende anfügen
list.add(10, 0);        // an Index einfügen
list.get(1);            // Element an Index
list.remove(0);         // Element entfernen
list.behead();          // Kopf entfernen
list.cutTailOff();      // Ende entfernen
list.toStringReverse(); // rückwärts ausgeben
```

## MyQueue

```java
MyQueue q = new MyQueue();
q.enqueue(1);
q.enqueue(2);
q.behead();       // → 1
q.dequeue(3);     // → int[] {2, 3, 4}
```


