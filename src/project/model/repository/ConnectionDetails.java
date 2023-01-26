/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.model.repository;
import project.model.CocktailDetails;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iliak
 */

public class ConnectionDetails {
    List<CocktailDetails> cocktaildetails=new ArrayList<CocktailDetails>();
    public List<CocktailDetails> getCocktailDetails(String id) throws IOException, InterruptedException, ParseException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i="+id)).GET().build();
        HttpResponse<String> response =client.send(request,HttpResponse.BodyHandlers.ofString());
        JSONParser jsonparser=new JSONParser();
        Object obj=jsonparser.parse(response.body());
        JSONObject cktobj=(JSONObject)obj;

        JSONArray array=(JSONArray)cktobj.get("drinks");

        for(int i=0;i<array.size();i++){
            JSONObject drinkdetails=(JSONObject) array.get(i);
            String iddrinkdetails=(String) drinkdetails.get("idDrink");
            String strdrinkdetails=(String) drinkdetails.get("strDrink");
            String strglassdetails=(String) drinkdetails.get("strGlass");
            String thumbdrinkdetails=(String) drinkdetails.get("strDrinkThumb");
            String instructions=(String) drinkdetails.get("strInstructions");
            String strIngredient1=(String) drinkdetails.get("strIngredient1");
            String strIngredient2=(String) drinkdetails.get("strIngredient2");
            String strIngredient3=(String) drinkdetails.get("strIngredient3");
            String strIngredient4=(String) drinkdetails.get("strIngredient4");
            String strIngredient5=(String) drinkdetails.get("strIngredient5");
            String strIngredient6=(String) drinkdetails.get("strIngredient6");
            String strIngredient7=(String) drinkdetails.get("strIngredient7");
            String strIngredient8=(String) drinkdetails.get("strIngredient8");
            String strIngredient9=(String) drinkdetails.get("strIngredient9");
            String strIngredient10=(String) drinkdetails.get("strIngredient10");
            String strIngredient11=(String) drinkdetails.get("strIngredient11");
            String strIngredient12=(String) drinkdetails.get("strIngredient12");
            String strIngredient13=(String) drinkdetails.get("strIngredient13");
            String strIngredient14=(String) drinkdetails.get("strIngredient14");
            String strIngredient15=(String) drinkdetails.get("strIngredient15");
            String strMeasure1=(String) drinkdetails.get("strMeasure1");
            String strMeasure2=(String) drinkdetails.get("strMeasure2");
            String strMeasure3=(String) drinkdetails.get("strMeasure3");
            String strMeasure4=(String) drinkdetails.get("strMeasure4");
            String strMeasure5=(String) drinkdetails.get("strMeasure5");
            String strMeasure6=(String) drinkdetails.get("strMeasure6");
            String strMeasure7=(String) drinkdetails.get("strMeasure7");
            String strMeasure8=(String) drinkdetails.get("strMeasure8");
            String strMeasure9=(String) drinkdetails.get("strMeasure9");
            String strMeasure10=(String) drinkdetails.get("strMeasure10");
            String strMeasure11=(String) drinkdetails.get("strMeasure11");
            String strMeasure12=(String) drinkdetails.get("strMeasure12");
            String strMeasure13=(String) drinkdetails.get("strMeasure13");
            String strMeasure14=(String) drinkdetails.get("strMeasure14");
            String strMeasure15=(String) drinkdetails.get("strMeasure15");
            CocktailDetails varcocktaildetails=new CocktailDetails(
                    iddrinkdetails,
                    strdrinkdetails,
                    strglassdetails,
                    instructions,
                    thumbdrinkdetails,
                    strIngredient1,strIngredient2,strIngredient3,strIngredient4,strIngredient5,strIngredient6,strIngredient7,strIngredient8,strIngredient9,strIngredient10,strIngredient11,strIngredient12,strIngredient13,strIngredient14,strIngredient15,
                    strMeasure1,strMeasure2,strMeasure3,strMeasure4,strMeasure5,strMeasure6,strMeasure7,strMeasure8,strMeasure9,strMeasure10,strMeasure11,strMeasure12,strMeasure13,strMeasure14,strMeasure15);
            cocktaildetails.add(varcocktaildetails);
        }
        return cocktaildetails;
    }
}
