package FabsesyaMuhammadJBusAF;

import java.util.ArrayList;
import java.util.*;
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Double> filteredList = new ArrayList<>();
        
        for (Price price : list) {
            if (less) {
                if (price.price <= value) {
                    filteredList.add(price.price);
                }
            } else {
                if (price.price > value) {
                    filteredList.add(price.price);
                }
            }
        }
        return filteredList;
    }
}
