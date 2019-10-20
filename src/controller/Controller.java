package controller;

import view.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    private Database db = new Database();

    public List<Figure> getFigures() {
        return db.getFigures();
    }

    public void addFigure(FormEvent e) {
        String name = e.getName();
        String shapeCat = e.getShape();
        double length = e.getLength();
        double width = e.getWidth();
        double height = e.getHeight();
        double radius = e.getRadius();
        double volume = 0;

        Shape shape = null;
        switch (shapeCat) {
            case "cube":
                shape = Shape.cube;
                volume = Math.pow(length, 3);
                break;
            case "cuboid":
                shape = Shape.cuboid;
                volume = length*width*height;
                break;
            case "cylinder":
                shape = Shape.cylinder;
                volume = Math.PI*Math.pow(radius,2)*height;
                break;
            case "sphere":
                shape = Shape.sphere;
                volume = 4/3*Math.PI*Math.pow(radius,3);
                break;
            case "cone":
                shape = Shape.cone;
                volume = 1/3*Math.PI*Math.pow(radius,2)*height;
                break;
        }

        Figure figure = new Figure(name, shape, volume);
        db.addFigure(figure);
    }

    public void removeFigure(int index) {
        db.removeFigure(index);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
