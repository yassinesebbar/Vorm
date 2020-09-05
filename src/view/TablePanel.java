package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import controller.iFigureTableListener;
import model.Figure;
import model.FigureTableModel;

public class TablePanel extends JPanel {

    private JTable table;
    private FigureTableModel tableModel;
    private JPopupMenu popup;
    private iFigureTableListener iFigureTableListener;

    public TablePanel() {
        tableModel = new FigureTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();

//      Popup wanneer een rij verwijderd wordt
        JMenuItem removeItem = new JMenuItem("Delete row");
        popup.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());

                table.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });

//      Kiest de juiste rij om te verwijderen
        removeItem.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (iFigureTableListener != null) {
                iFigureTableListener.rowDeleted(row);
                tableModel.fireTableRowsDeleted(row, row);
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Figure> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void setFigureTableListener(iFigureTableListener listener) {
        this.iFigureTableListener = listener;
    }
}
