package project.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import project.model.CocktailDao;
import project.model.CocktailDaoImpl;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;


public class AddFavCocktail implements ActionListener {
    private String id;

    public AddFavCocktail(String id){
        this.id=id;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int temp=0;
        try {
            CocktailDao dao=new CocktailDaoImpl();
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("src//fav.json");
            Object obj = jsonParser.parse(reader);
            JSONObject cktobj = (JSONObject)obj;
            JSONArray array = (JSONArray)cktobj.get("drinks");
            for(int i = 0; i < array.size(); ++i) {
                JSONObject drinks = (JSONObject)array.get(i);
                String iddrink = (String)drinks.get("iddrink");
                if (iddrink.equals(id)) {
                    System.out.println("It Exists");
                    temp=1;
                }
                else {
                    continue;
                }

            }
            if(temp==0){
                dao.addCocktailFav(id);}

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
