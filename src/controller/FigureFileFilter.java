package controller;

import view.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

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

        return extension.equals("fig");
    }

    @Override
    public String getDescription() {
        return "Figure database files (*.fig)";
    }
}
