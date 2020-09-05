package model;

public class Sphere extends Figure {
    double radius;

    public Sphere(String name, Shape shape, double radius) {
        super(name, shape);
        this.radius = radius;

        this.volume = ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3));
    }
}


