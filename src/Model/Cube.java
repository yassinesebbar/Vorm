package model;

public class Cube extends Figure {
    private double length;

    public Cube(String name, Shape shape, double length) {
        super(name, shape);
        this.length = length;
        this.volume = Math.pow(length, 3);
    }
}