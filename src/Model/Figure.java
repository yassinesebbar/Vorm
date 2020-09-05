package model;

import java.io.Serializable;

public abstract class Figure implements iFigure, Serializable {
    private int id;
    private String name;
    private Shape shape;
    public double volume;
    static int count = 1;

    public Figure(String name, Shape shape) {
        this.name = name;
        this.shape = shape;
    }

    public void setId() {
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }

    public double getVolume() {
        return volume;
    }
}