import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue q;

    @BeforeEach
    void setup() {
        q = new MyQueue();
    }

    @Test
    void testEnqueueAndSize() {
        q.enqueue(10);
        q.enqueue(20);
        assertEquals(2, q.size());
    }

    @Test
    void testBehead() {
        q.enqueue(10);
        q.enqueue(20);
        int val = q.behead();
        assertEquals(10, val, "First element must be 10.");
        assertEquals(1, q.size(), "Size must be 1 after behead.");
    }

    @Test
    void testDequeueArray() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        int[] expected = {1, 2};
        assertArrayEquals(expected, q.dequeue(2));
        assertEquals(1, q.size());
    }

    @Test
    void beheadOnEmptyQueueShouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> q.behead());
    }
}
