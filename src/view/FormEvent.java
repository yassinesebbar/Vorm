package view;

import model.Shape;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private model.Shape shape;
    private double length;
    private double width;
    private double height;
    private double radius;

    public FormEvent(Object source, String name, model.Shape shape, double length, double width, double height, double radius) {
        super(source);
        this.name = name;
        this.shape = shape;
        this.length = length;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }


    public String getName() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }
}
