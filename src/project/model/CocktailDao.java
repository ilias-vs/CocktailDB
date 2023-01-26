//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package project.model;

import java.util.List;

/**
 *
 * @author iliak
 */
public interface CocktailDao {
    List<Cocktail> getAllFavCocktails();

    public int getDetails(String id);

    Favourite getFavCocktail(String var1);

    void addCocktailFav(String var1) throws Exception;

    void deleteCocktailFav(String var1);
}
