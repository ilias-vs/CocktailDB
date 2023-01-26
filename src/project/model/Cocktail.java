package project.model;
/**
 *
 * @author iliak
 */
public class Cocktail {

    private String name;
    private String drinkThumb;
    private String idDrink;

    public Cocktail(String name,String drinkThumb,String idDrink){
        this.name=name;
        this.drinkThumb=drinkThumb;
        this.idDrink=idDrink;

    }

    public String getName(){
        return name;
    }

    public String getDrinkThumb(){
        return drinkThumb;
    }

    public String getidDrink(){
        return idDrink;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setDrinkThumb(String drinkThumb){
        this.drinkThumb=drinkThumb;
    }
    public void setIdDrink(String idDrink){
        this.idDrink=idDrink;
    }

}

