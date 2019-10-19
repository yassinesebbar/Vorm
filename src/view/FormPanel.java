package view;

import controller.FormListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

        // Set up mnemonics
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);
        okBtn.setMnemonic(KeyEvent.VK_O);

        // Set up combo box
        DefaultComboBoxModel shapeModel = new DefaultComboBoxModel();
        shapeModel.addElement("cube");
        shapeModel.addElement("cuboid");
        shapeModel.addElement("cylinder");
        shapeModel.addElement("sphere");
        shapeModel.addElement("cone");
        shapeCombo.setModel(shapeModel);
        shapeCombo.setSelectedIndex(0);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String shape = (String) shapeCombo.getSelectedItem();
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                double radius = Double.parseDouble(radiusField.getText());

                FormEvent ev = new FormEvent(this, name, shape, length, width, height, radius);

                if (formListener != null) {
                    formListener.formEventOccurred(ev);
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