package project.view;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project.model.CocktailDetails;
import project.model.repository.ConnectionDetails;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavouriteFrame extends JFrame {
    public FavouriteFrame(){
        super.setTitle("Favourite List");// orizi titlo tou programatos
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// termatizi to programa mas
        super.setSize(400,400);
        super.setLayout(new BorderLayout());

        //dimiourgia kainourgion frame
        JPanel topPanel=new JPanel(new FlowLayout());
        JPanel centerPanel=new JPanel(new GridLayout(0,4,10,10));
        JScrollPane scroll = new JScrollPane();
        topPanel.setPreferredSize(new Dimension(0,50));
        JLabel welcome= new JLabel("Favourite CockTail List");
        welcome.setFont(new Font("Calibri", Font.BOLD, 20));
        topPanel.add(welcome);

        //center panel
        centerPanel.setBackground(Color.lightGray);

        //scroll control
        scroll.setViewportView(centerPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(20);

        List<CocktailDetails> cocktails = new ArrayList<CocktailDetails>();
        ConnectionDetails bla = new ConnectionDetails();

        JSONParser jsonParser= new JSONParser();
        try {

            FileReader reader=new FileReader("src//fav.json");
            Object obj= jsonParser.parse(reader);
            JSONObject cktobj=(JSONObject)obj;
            JSONArray array=(JSONArray)cktobj.get("drinks");

            for(int i=0;i<array.size();i++){
                JSONObject drinks=(JSONObject)array.get(i);
                cocktails=bla.getCocktailDetails((String) drinks.get("iddrink"));
                FavouritePanel panel=new FavouritePanel(cocktails.get(i).getStrDrink(),cocktails.get(i).getStrDrinkThumb(),cocktails.get(i).getIdDrink());
                centerPanel.add(panel);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //dimiourgia twn cocktail frames mas



        //prosthiki antikimenon sto main frame mas!
        super.add(scroll,BorderLayout.CENTER);
        super.add(topPanel,BorderLayout.NORTH);
        pack();




    }
}

