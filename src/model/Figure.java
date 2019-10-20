package model;

import java.io.Serializable;

public class Figure implements Serializable {

    private static final long serialVersionUID = 5060623020008445057L;

    private static int count = 0;
    private int id;
    private String name;
    private Shape shape;
    private double length;
    private double volume;

    public Figure(String name, Shape shape, double volume) {
        this.name = name;
        this.shape = shape;
        this.volume = volume;

        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
