package model;

import java.io.*;
import java.util.*;

public class Database {


    private List<Figure> figures;

    //Maakt een database aan op basis van een lijst
    public Database() {
        figures = new LinkedList<>();
    }

    //Voegt figuren toe aan de lijst
    public void addFigure(Figure figure) {
        figures.add(figure);
        figure.setId();
    }

    //Verwijdert figuren uit de lijst
    public void removeFigure(int index) {
        figures.remove(index);
    }

    //Haalt figuren op uit de lijst
    public List<Figure> getFigures() {
        return Collections.unmodifiableList(figures);
    }

    //Schrijft lijst weg als bestand
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Figure[] figures = this.figures.toArray(new Figure[this.figures.size()]);

        oos.writeObject(figures);
        oos.close();
    }

    //Leest bestand in als lijst
    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Figure[] figures = (Figure[]) ois.readObject();
            this.figures.clear();
            this.figures.addAll(Arrays.asList(figures));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }
}
