package project.view;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import project.controller.ShowFavList;
import project.model.Cocktail;
import project.model.repository.Connection;
import project.model.repository.ConnectionDetails;

/**
 *
 * @author iliak
 */

public class MainFrame extends JFrame {
    private String img;

    public MainFrame(String img) {
        this.img=img;

        // to kirios frame!
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// termatizi to programa mas
        this.setSize(1280,720);
        this.setLayout(new BorderLayout());

        //dimiourgia kainourgion frame
        JPanel topPanel=new JPanel(new FlowLayout());
        JPanel centerPanel=new JPanel(new GridLayout(0,4,10,10));
        JScrollPane scroll = new JScrollPane();
        topPanel.setPreferredSize(new Dimension(0,50));
        JLabel welcome= new JLabel("Welcome to Cocktail DB");
        welcome.setFont(new Font("Calibri", Font.BOLD, 20));
        JButton favList=new JButton("Show Fav List");
        ShowFavList listbutton=new ShowFavList();
        favList.addActionListener(listbutton);
        topPanel.add(welcome);
        topPanel.add(favList);

        //center panel
        centerPanel.setBackground(Color.lightGray);

        //scroll control
        scroll.setViewportView(centerPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(20);

        List<Cocktail> cocktails = new ArrayList<Cocktail>();
        Connection bla = new Connection();
        try {
            cocktails = bla.getCocktails();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //dimiourgia twn cocktail frames mas
        for(int i=0;i<cocktails.size();i++){

            CocktailPanel panel=new CocktailPanel(cocktails.get(i).getName(),cocktails.get(i).getDrinkThumb(),cocktails.get(i).getidDrink());
            centerPanel.add(panel);
        }


        //prosthiki antikimenon sto main frame mas!
        this.add(scroll,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);



        this.setVisible(true);

    }
}