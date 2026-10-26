package Shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorking {

    @Test
    void getAreaTestCircle() {
        Shapes c = new Circle("green", true , 3);
        assertEquals(18.85,c.getArea(),0.01);
    }

    @Test
    void getPerimeterTestCircle() {
        Shapes c = new Circle("blue",true,3);
        assertEquals(28.27,c.getPerimeter(),0.01);
    }

    @Test
    void getAreaTestRectangle() {
        Shapes r = new Rectangle("\u001B[33m", true, 10, 5);
        assertEquals(50,r.getArea(),0.01);
    }

    @Test
    void getPerimeterTestRectangle() {
        Shapes r = new Rectangle("\u001B[33m", true, 10, 5);
        assertEquals(100,r.getPerimeter(),0.01);
    }

    @Test
    void getAreaTestSquare(){
        Shapes s = new Square("\u001B[35m", true, 10);
        assertEquals(100,s.getArea(),0.01);
    }
    @Test
    void getPerimeterTestSquare(){
        Shapes s = new Square("\u001B[35m", true, 10);
        assertEquals(200, s.getPerimeter(),0.01);
    }

}
