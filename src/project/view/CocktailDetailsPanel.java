package project.view;

import project.model.CocktailDaoImpl;
import project.model.CocktailDetails;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CocktailDetailsPanel extends JFrame {


    public CocktailDetailsPanel(List<CocktailDetails> cokdetails,String id) throws IOException, InterruptedException {
        super(id);
        CocktailDaoImpl dao = new CocktailDaoImpl();
        int temp=dao.getDetails(id);


        super.setLayout(new BorderLayout());


        //dimiourgia ton esoterikwn frames

        //Titlos tou cocktail
        JPanel title =new JPanel();
        JLabel titleLabel=new JLabel(cokdetails.get(temp).getStrDrink());
        title.add(titleLabel);

        //ikona tou cocktail
        JPanel imagePanel=new JPanel();
        try{
            URL urlimg=new URL(cokdetails.get(temp).getStrDrinkThumb());
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

        //details

        JPanel deals = new JPanel(new GridLayout(0,2,5,5));
        JLabel igr = new JLabel("Ingredients");
        JLabel msr = new JLabel("Measure");
        JLabel igr1 =new JLabel(cokdetails.get(temp).getStrIngredient1());
        JLabel igr2 =new JLabel(cokdetails.get(temp).getStrIngredient2());
        JLabel igr3 =new JLabel(cokdetails.get(temp).getStrIngredient3());
        JLabel igr4 =new JLabel(cokdetails.get(temp).getStrIngredient4());
        JLabel msr1 = new JLabel(cokdetails.get(temp).getStrMeasure1());
        JLabel msr2 = new JLabel(cokdetails.get(temp).getStrMeasure2());
        JLabel msr3 = new JLabel(cokdetails.get(temp).getStrMeasure3());
        JLabel msr4 = new JLabel(cokdetails.get(temp).getStrMeasure4());
        deals.add(igr);
        deals.add(msr);
        deals.add(igr1);
        deals.add(msr1);
        deals.add(igr2);
        deals.add(msr2);
        deals.add(igr3);
        deals.add(msr3);
        deals.add(igr4);
        deals.add(msr4);
        deals.add(new JLabel("Glass:"));
        deals.add(new JLabel(cokdetails.get(temp).getStrGlass()));
        deals.add(new JLabel("Instructions:"));
        deals.add(new JLabel(cokdetails.get(temp).getStrInstructions()));







        //prosthiki sto kentriko mas frame
        super.add(deals,BorderLayout.SOUTH);
        super.add(title,BorderLayout.NORTH);
        super.add(imagePanel,BorderLayout.CENTER);
        pack();

    }

}
