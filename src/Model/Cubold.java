package Model;

public class Cubold extends Shape {

    private double length;
    private double widht;
    private double height;

    public Cubold(double length , double width, double height ){

        this.length = length;
        this.widht = width;
        this.height = height;

        this.shapeName = "Cubold";
        this.space = this.calcVolume();
    }

    private double calcVolume(){
        return this.length * this.widht * this.height;
    }

}
