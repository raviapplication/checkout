package com.shop.till;

import java.util.HashMap;
import java.util.List;

/**
 */
public class Checkout {

    private HashMap<String, Double> itemsOnSale = new HashMap<>();

    public Checkout() {
        itemsOnSale.put("Apple", 0.60);
        itemsOnSale.put("Orange", 0.25);
    }

    public Double billItems(List<String> basket) {

        Double total = 0.0;

        for(String item: basket) {
            if(itemsOnSale.get(item) != null) {
                total += itemsOnSale.get(item);
            }
        }
        return total;
    }
}
