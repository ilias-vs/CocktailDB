package project.factory;

import project.controller.OSActionListener;

import javax.swing.*;
import java.awt.*;

public class MainFactoryJFrame extends JDialog {
    public MainFactoryJFrame(){

        maker();
    }


    private void maker() {
        this.setPreferredSize(new Dimension(500, 100));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        JComboBox<String> combo = new JComboBox();
        combo.addItem("Windows");
        combo.addItem("Mac");
        combo.addItem("Linux");
        combo.setOpaque(false);
        JButton button = new JButton("Continue");
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new OSActionListener(combo, this));
        JPanel myPanel = new JPanel(new GridLayout(0, 1));
        myPanel.add(combo);
        myPanel.add(button);
        add(myPanel);
        pack();
    }


}
