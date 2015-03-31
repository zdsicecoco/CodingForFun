package chapter3;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */

import java.util.ArrayList;
import java.util.List;

public class BearExpert {
    public List getBrands(String color) {
        List brands = new ArrayList();
        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return (brands);
    }
}