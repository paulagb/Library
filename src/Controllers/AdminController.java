package Controllers;

import service.Library;
import ui.MainAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener {
    private MainAdmin view;
    private Library logic;

    public AdminController(MainAdmin loginView, Library logic) {
        this.view = loginView;
        this.logic = logic;
        //loginView.showView(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btAdd")) {
            //TODO ADD BOOK
        } else if (e.getActionCommand().equals("btDiscard")) {
            //TODO DISCARD BOOK
        } else if (e.getActionCommand().equals("btImage")) {
            //TODO ADD IMAGE
        }

    }

    public void displayView(boolean b) {
        view.showView(b);
    }
}

