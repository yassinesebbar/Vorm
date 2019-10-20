package Model;

public class Sphere extends Shape{

    private double radius;

    public Sphere(double radius){
        this.radius = radius;

        this.shapeName = "Sphere";
        this.space = this.calcVolume();
    }

    private double calcVolume(){

        double cubeTheRadius = Math.pow(3, this.radius);
        double multiplyTheCubed = (1 / 4 * 3)  * Math.PI * cubeTheRadius;
        return multiplyTheCubed;
    }

}
