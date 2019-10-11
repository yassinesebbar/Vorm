package Model;

public class RectangularPyramid extends Shape {

    private double length;
    private double width;
    private double height;

    public RectangularPyramid(double length, double width, double height){
        this.height = height;
        this.length = length;
        this.width = width;

        this.shapeName = "RectangularPyramid";

        this.space = this.calcVolume();
    }

    private double calcVolume(){
        return (1/3) * (this.length * this.width * this.height);
    }

}
