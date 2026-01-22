package Shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFailure {
    @Test
    void getAreaTestCircle() {
        Shapes c = new Circle("green", true, 3);
        assertNotEquals(15, c.getArea(), 0.01);
    }

    @Test
    void exceptionTestCircle() {
        assertThrows(IllegalArgumentException.class, () -> new Circle("green", true, -3));
    }


}
