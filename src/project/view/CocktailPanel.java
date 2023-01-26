package project.view;

import project.controller.AddFavCocktail;
import project.controller.MouseCocktail;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;

public class CocktailPanel extends JPanel {
     public CocktailPanel(String cocktailname,String cocktailimg,String id){
         //dimiourgia kentrikou frame
         this.setLayout(new BorderLayout());
         //dimiourgia ton esoterikwn frames

         //Titlos tou cocktail
         JPanel title =new JPanel();
         JLabel titleLabel=new JLabel(cocktailname);
         title.add(titleLabel);

         //ikona tou cocktail
         JPanel imagePanel=new JPanel();
         try{
            URL urlimg=new URL(cocktailimg);
             BufferedImage buffer = ImageIO.read(urlimg);
             ImageIcon imageIcon = new ImageIcon(buffer); // load the image to a imageIcon
             Image image = imageIcon.getImage();
             Image scaling = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
             imageIcon = new ImageIcon(scaling);
             JLabel imageLabel = new JLabel(imageIcon,JLabel.CENTER);
             imagePanel.add(imageLabel);
         }catch(IOException e){
             System.out.println(e);
         }

         //koubi tou cocktail

         JButton button=new JButton("Add Favourite");
         AddFavCocktail favbutton= new AddFavCocktail(id);
         button.addActionListener(favbutton);

        // panel clickable
         JPanel fuctions=new JPanel();
         fuctions.add(button);

         MouseCocktail action=new MouseCocktail(id);
         this.addMouseListener(action);




         //prosthiki sto kentriko mas frame

         this.add(title,BorderLayout.NORTH);
         this.add(imagePanel,BorderLayout.CENTER);
         this.add(fuctions,BorderLayout.PAGE_END);


     }
}
