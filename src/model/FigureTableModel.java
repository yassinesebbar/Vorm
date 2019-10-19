package model;

import model.Figure;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FigureTableModel extends AbstractTableModel {

    private List<Figure> db;

    private String[]
            colNames = {"ID", "Name", "Shape", "Volume"};

    public FigureTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Figure> db) {
        this.db = db;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Figure figure = db.get(row);

        switch (col) {
            case 0:
                return figure.getId();
            case 1:
                return figure.getName();
            case 2:
                return figure.getShape();
            case 3:
                return figure.getVolume();
        }
        return null;
    }
}
