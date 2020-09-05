package model;

public class Cuboid extends Figure {
    private double length;
    private double width;
    private double height;

    public Cuboid(String name, Shape shape, double length, double width, double height) {
        super(name, shape);
        this.length = length;
        this.width = width;
        this.height = height;

        this.volume = (length * width * height);
    }
}

