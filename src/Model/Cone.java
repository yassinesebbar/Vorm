package Model;

public class Cone extends Shape {

    private double radius;
    private double height;

    public Cone(double radius, double height){

        this.height = height;
        this.radius = radius;

        this.shapeName = "Cone";
        this.space = this.calcVolume();

    }

    private double calcVolume(){
            return (1/3) * Math.PI * Math.pow(2 , this.radius) * this.height;
    }


}
