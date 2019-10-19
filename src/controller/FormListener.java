package controller;

import view.FormEvent;

import java.util.EventListener;

public interface FormListener extends EventListener {
    void formEventOccurred(FormEvent e);
}
