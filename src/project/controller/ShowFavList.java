package project.controller;


import project.view.FavouriteFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowFavList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        FavouriteFrame fav=new FavouriteFrame();
        fav.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fav.setVisible(true);
    }
}
