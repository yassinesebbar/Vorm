package model;

import java.io.Serializable;

public class Figure implements Serializable {

    private static final long serialVersionUID = 5060623020008445057L;

    private static int count = 0;
    private int id;
    private String name;
    private Shape shape;
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
