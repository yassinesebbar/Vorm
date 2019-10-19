package model;

import java.io.*;
import java.util.*;

public class Database {

    private List<Figure> figures;

    public Database() {
        figures = new LinkedList<>();
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void removeFigure(int index) {
        figures.remove(index);
    }

    public List<Figure> getFigures() {
        return Collections.unmodifiableList(figures);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Figure[] figures = this.figures.toArray(new Figure[this.figures.size()]);

        oos.writeObject(figures);

        oos.close();
    }

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
