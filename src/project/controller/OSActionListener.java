package project.controller;

import project.factory.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OSActionListener implements ActionListener {
     JComboBox<String> comboBox;
     JDialog dialog;
    public OSActionListener(JComboBox<String> comboBox,JDialog dialog){
        this.comboBox=comboBox;
        this.dialog= dialog;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
        OSFactory osfactory = new OSFactory();
        (osfactory.getOs(comboBox.getSelectedItem().toString())).draw();
    }
}
