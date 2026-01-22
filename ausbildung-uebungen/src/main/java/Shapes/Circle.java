package Shapes;

public class Circle extends Shapes {

    private double radius;



    public Circle(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        if (radius <= 0) throw new IllegalArgumentException("Radius has to be > 0");
        this.radius = radius;
    }

    public double getArea() {
        return 2 * Math.PI * radius;

    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * radius;
    }


}