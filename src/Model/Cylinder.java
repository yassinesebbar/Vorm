package Model;

public class Cylinder extends Shape {

    private double radius;
    private double height;

    public Cylinder(double radius, double height){
        this.height = height;
        this.radius = radius;

        this.shapeName = "Cylinder";
        this.space = this.calcVolume();
    }

    private double calcVolume(){
        double areaCircularBase = Math.PI * Math.pow(2, this.radius);
        double coneVolume = areaCircularBase * this.height;

        return coneVolume;
    }

}
