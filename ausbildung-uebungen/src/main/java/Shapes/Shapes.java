package Shapes;

public abstract class Shapes {

    private String color;
    private String name;
    private Boolean isFilled;

    public Shapes(String color, Boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;

    }

    public abstract double getArea();

    public abstract double getPerimeter();

    //Getter


    //Setter


}
