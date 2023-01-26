package project.factory;


import project.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Windows implements OS{

    @Override
    public void draw(){
        String img="src//windows.png";
        System.out.println("Loading Assets...");
        MainFrame frame=new MainFrame(img);
        frame.setTitle("Cocktails For Windows");
        frame.setVisible(true);
    }
}
