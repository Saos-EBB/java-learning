import Shapes.*;

void main() {
    Shapes kreis = new Circle("\u001B[34m", true, 3);
    Shapes quadrat = new Square("\u001B[35m", true, 10);
    Shapes rechteck = new Rectangle("\u001B[33m", true, 10, 5);


    //WERFEN ALLE ERROR , ist das ausreichend ?
    // Shapes kreisTest = new Circle("\u001B[33m", false , 0);
    // Shapes squareTest = new Square("\u001B[33m", false,0);
    //Shapes recTest = new Rectangle("\u001B[33m", true, 0 , 10);


    System.out.printf("Kreis Fläche : %.2f \n" , kreis.getArea());
    System.out.printf("Kreis Umfang : %.2f \n" , kreis.getPerimeter());
    System.out.printf("Quadrat Fläche :%.2f \n" , quadrat.getArea());
    System.out.printf("Quadrat Umfang :%.2f \n" , quadrat.getPerimeter());
    System.out.printf("Rechteck Fläche :%.2f \n" , rechteck.getArea());
    System.out.printf("Rechteck Umfang :%.2f \n" , rechteck.getPerimeter());


}