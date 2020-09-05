package model;

public class Cylinder extends Figure {
    private double radius;
    private double height;

    public Cylinder(String name, Shape shape, double radius, double height) {
        super(name, shape);
        this.radius = radius;
        this.height = height;

        this.volume = (Math.PI*Math.pow(radius, 2)*height);
    }
}


