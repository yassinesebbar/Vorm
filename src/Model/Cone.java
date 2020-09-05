package model;

public class Cone extends Figure {
    private double radius;
    private double height;

    public Cone(String name, Shape shape, double radius, double height) {
        super(name, shape);
        this.radius = radius;
        this.height = height;

        this.volume = (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
}
