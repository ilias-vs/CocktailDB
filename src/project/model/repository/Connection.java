//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package project.model.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.model.Cocktail;
import project.model.main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author iliak
 */

public class Connection {
    List<Cocktail> cocktails = new ArrayList();

    public Connection() {
    }

    public List<Cocktail> getCocktails() throws IOException, InterruptedException {
        //get connection
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail")).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        //ftiaxnoume enan parser
        JSONParser jsonparser = new JSONParser();

        try {
            //vazoume to string mas mesa sto obj
            Object obj = jsonparser.parse((String)response.body());
            //metatrepoume se JSONObject
            JSONObject cktobj = (JSONObject)obj;
            //meta kaloume ti drinks array
            JSONArray array = (JSONArray)cktobj.get("drinks");
            //edw kanoume ti epanalipsi gia ola ta cocktails kai ta vazoume sti locally stored
            for(int i = 0; i < array.size(); ++i) {
                JSONObject drinks = (JSONObject)array.get(i);
                String iddrink = (String)drinks.get("idDrink");
                String thumbdrink = (String)drinks.get("strDrinkThumb");
                String strdrink = (String)drinks.get("strDrink");
                Cocktail varcocktail = new Cocktail(strdrink, thumbdrink, iddrink);
                this.cocktails.add(varcocktail);
            }
        } catch (ParseException var14) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, (String)null, var14);
        }
        //epistrofi ton cocktails
        return this.cocktails;
    }
}
