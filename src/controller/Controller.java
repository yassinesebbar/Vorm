package controller;

import view.FormEvent;
import model.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    //Maakt de databaselijst aan
    private Database db = new Database();

//Functie om de lijst van objecten op te halen
    public List<Figure> getFigures() {
        return db.getFigures();
    }

//Functie om figuren toe te voegen aan de database
    public void addFigure(FormEvent e) {
        String name = e.getName();
        model.Shape shape = e.getShape();

        double length = e.getLength();
        double width = e.getWidth();
        double height = e.getHeight();
        double radius = e.getRadius();

//Keuze uit de combobox
        switch (shape) {
            case cube:
                Figure Cube = new Cube(name, shape, length);
                db.addFigure(Cube);
                break;
            case cuboid:
                Figure Cuboid = new Cuboid(name, shape, length, width, height);
                db.addFigure(Cuboid);
                break;
            case cylinder:
                Figure Cylinder = new Cylinder(name, shape, radius, height);
                db.addFigure(Cylinder);
                break;
            case sphere:
                Figure Sphere = new Sphere(name, shape, radius);
                db.addFigure(Sphere);
                break;
            case cone:
                Figure Cone = new Cone(name, shape, radius, height);
                db.addFigure(Cone);
                break;
        }
    }

    //Verwijdert figuren uit de lijst
    public void removeFigure(int index) {
        db.removeFigure(index);
    }

    //Schrijft de lijst weg als bestand
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    //Haalt bestand op
    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
