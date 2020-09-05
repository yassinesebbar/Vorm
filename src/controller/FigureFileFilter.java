package controller;

import model.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

//Controleert of de extensie klopt met .fig
public class FigureFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {

        if(file.isDirectory()) {
            return true;
        }

        String name = file.getName();

        String extension = Utils.getFileExtension(name);

        if(extension == null) {
            return false;
        }

        if(extension.equals("fig")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Figure database files (*.fig)";
    }
}
