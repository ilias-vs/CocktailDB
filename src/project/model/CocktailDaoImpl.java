//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package project.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author iliak
 */

public class CocktailDaoImpl implements CocktailDao {
    List<CocktailDetails> cokdetails = new ArrayList();
    List<Favourite> favourites;
    public CocktailDaoImpl(List<Favourite> favourites){
        this.favourites=favourites;
    }

    public CocktailDaoImpl() throws IOException, InterruptedException {
    }

    public List<Cocktail> getAllFavCocktails() {
        return null;
    }

    @Override
    public int getDetails(String id) {
        int temp = 0;
        for(int i=0;i<cokdetails.size();i++){
            if(cokdetails.get(i).getIdDrink()==id){
                temp=i;
                break;
            }
            else continue;
        }
        return temp;
    }
    @Override
    public Favourite getFavCocktail(String idDrink) {

        return null;
    }
    @Override
    public void addCocktailFav(String id) throws Exception {
        JSONParser jsonParser = new JSONParser();

        try {//edw dimiourgoume ena json arxio
            FileReader reader = new FileReader("src//fav.json");

            try {
                JSONArray favList = new JSONArray();

                JSONObject obj3;
                try {
                    Object obj = jsonParser.parse(reader);
                    obj3 = (JSONObject)obj;
                    JSONArray array = (JSONArray)obj3.get("drinks");

                    for(int i = 0; i < array.size(); ++i) {
                        JSONObject drinks = (JSONObject)array.get(i);
                        String iddrink = (String)drinks.get("iddrink");
                        JSONObject obj4 = new JSONObject();
                        obj4.put("iddrink", iddrink);
                        favList.add(obj4);
                    }
                } catch (ParseException var13) {
                    System.out.println(var13);
                }

                JSONObject obj2 = new JSONObject();
                obj2.put("iddrink", id);
                favList.add(obj2);
                obj3 = new JSONObject();
                obj3.put("drinks", favList);
                FileWriter file = new FileWriter("src//fav.json");
                file.write(obj3.toJSONString());
                file.flush();
            } catch (Throwable var14) {
                try {
                    reader.close();
                } catch (Throwable var12) {
                    var14.addSuppressed(var12);
                }

                throw var14;
            }

            reader.close();
        } catch (Exception var15) {
            throw var15;
        }
    }
    @Override
    public void deleteCocktailFav(String id) {
        int position = 0;
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("src//fav.json");

            try {
                try {
                    Object obj = jsonParser.parse(reader);
                    JSONObject cktobj = (JSONObject)obj;
                    JSONArray array = (JSONArray)cktobj.get("drinks");

                    for(int i = 0; i < array.size(); ++i) {
                        JSONObject drinks = (JSONObject)array.get(i);
                        String iddrink = (String)drinks.get("iddrink");
                        if (iddrink == id) {
                            position = i;
                        }
                    }

                    if (position >= 0) {
                        array.remove(position);
                    }

                    JSONObject obj3 = new JSONObject();
                    obj3.put("drinks", array);
                    FileWriter file = new FileWriter("src//fav.json");
                    file.write(obj3.toJSONString());
                    file.flush();
                } catch (ParseException var12) {
                    System.out.println(var12);
                }
            } catch (Throwable var13) {
                try {
                    reader.close();
                } catch (Throwable var11) {
                    var13.addSuppressed(var11);
                }

                throw var13;
            }

            reader.close();
        } catch (FileNotFoundException var14) {
            var14.printStackTrace();
        } catch (IOException var15) {
            var15.printStackTrace();
        }

    }
}
