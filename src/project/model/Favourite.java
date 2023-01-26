//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iliak
 */

public class Favourite {
    private String id;
    private String thumb;
    private String str;
    public Favourite(String id,String thumb,String str) {
        this.id=id;
        this.thumb=thumb;
        this.str=str;
    }

    public String getId() {
        return id;
    }

    public String getStr() {
        return str;
    }

    public String getThumb() {
        return thumb;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public static enum favourite {;
        private favourite() {
        }
    }
}
