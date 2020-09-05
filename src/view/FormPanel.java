package view;

import controller.FormListener;
import model.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private FormListener formListener;
    private JComboBox shapeCombo;
    private JLabel lengthLabel;
    private JTextField lengthField;
    private JLabel widthLabel;
    private JTextField widthField;
    private JLabel heightLabel;
    private JTextField heightField;
    private JLabel radiusLabel;
    private JTextField radiusField;
    private JButton okBtn;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);
        shapeCombo = new JComboBox();
        lengthLabel = new JLabel("Length: ");
        lengthField = new JTextField(10);
        widthLabel = new JLabel("Width: ");
        widthField = new JTextField(10);
        heightLabel = new JLabel("Height: ");
        heightField = new JTextField(10);
        radiusLabel = new JLabel("Radius: ");
        radiusField = new JTextField(10);
        okBtn = new JButton("OK");

        lengthLabel.setVisible(true);
        lengthField.setVisible(true);
        widthLabel.setVisible(false);
        widthField.setVisible(false);
        heightLabel.setVisible(false);
        heightField.setVisible(false);
        radiusLabel.setVisible(false);
        radiusField.setVisible(false);

        // Set up mnemonics (sneltoetsen)
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);
        okBtn.setMnemonic(KeyEvent.VK_O);

        // Set up combo box
        DefaultComboBoxModel shapeModel = new DefaultComboBoxModel();
//Haalt classes op uit enumlist
        for (model.Shape i: model.Shape.values()){
            shapeModel.addElement(i);
        }
        shapeCombo.setModel(shapeModel);
        shapeCombo.setSelectedIndex(0);

        okBtn.addActionListener(new ActionListener() {
            double length = 0;
            double width = 0;
            double height = 0;
            double radius = 0;

            //Haalt gegevens op uit invoervelden
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Shape shape = (Shape) shapeCombo.getSelectedItem();
                try {
                    length = Double.parseDouble(lengthField.getText());
                } catch (NumberFormatException nfe) {
                    length = 0.0;
                }
                try {
                    width = Double.parseDouble(widthField.getText());
                } catch (NumberFormatException nfe) {
                    width = 0.0;
                }
                try {
                    height = Double.parseDouble(heightField.getText());
                } catch (NumberFormatException nfe) {
                    height = 0.0;
                }
                try {
                    radius = Double.parseDouble(radiusField.getText());
                } catch (NumberFormatException nfe) {
                    radius = 0.0;
                }

                FormEvent ev = new FormEvent(this, name, shape, length, width, height, radius);

                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });

        //Laat invoervelden zien afhankelijk van de combobox
        shapeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(shapeCombo.getSelectedItem(), Shape.cube)) {
                    lengthLabel.setVisible(true);
                    lengthField.setVisible(true);
                    widthLabel.setVisible(false);
                    widthField.setVisible(false);
                    heightLabel.setVisible(false);
                    heightField.setVisible(false);
                    radiusLabel.setVisible(false);
                    radiusField.setVisible(false);
                }
                if (Objects.equals(shapeCombo.getSelectedItem(), Shape.cuboid)) {
                    lengthLabel.setVisible(true);
                    lengthField.setVisible(true);
                    widthLabel.setVisible(true);
                    widthField.setVisible(true);
                    heightLabel.setVisible(true);
                    heightField.setVisible(true);
                    radiusLabel.setVisible(false);
                    radiusField.setVisible(false);
                }
                if (shapeCombo.getSelectedItem().equals(Shape.cylinder)) {
                    lengthLabel.setVisible(false);
                    lengthField.setVisible(false);
                    widthLabel.setVisible(false);
                    widthField.setVisible(false);
                    heightLabel.setVisible(true);
                    heightField.setVisible(true);
                    radiusLabel.setVisible(true);
                    radiusField.setVisible(true);
                }
                if (shapeCombo.getSelectedItem().equals(Shape.sphere)) {
                    lengthLabel.setVisible(false);
                    lengthField.setVisible(false);
                    widthLabel.setVisible(false);
                    widthField.setVisible(false);
                    heightLabel.setVisible(false);
                    heightField.setVisible(false);
                    radiusLabel.setVisible(true);
                    radiusField.setVisible(true);
                }
                if (Shape.cone.equals(shapeCombo.getSelectedItem())) {
                    lengthLabel.setVisible(false);
                    lengthField.setVisible(false);
                    widthLabel.setVisible(false);
                    widthField.setVisible(false);
                    heightLabel.setVisible(true);
                    heightField.setVisible(true);
                    radiusLabel.setVisible(true);
                    radiusField.setVisible(true);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Figure");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///// Name row /////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 0;
        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ///// Figure row /////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Figure: "), gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(shapeCombo, gc);

        ///// Length row /////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(lengthLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(lengthField, gc);


        ///// Width row /////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(widthLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(widthField, gc);

        ///// Height row /////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(heightLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(heightField, gc);

        ///// Radius row /////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(radiusLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(radiusField, gc);

        ///// OK Button row /////
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.gridy++;

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}