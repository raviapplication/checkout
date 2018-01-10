package com.shop.till;

import com.shop.offers.Buy1Get1Free;
import com.shop.offers.Buy3ForPriceOf2;
import com.shop.offers.Offer;

import java.util.HashMap;
import java.util.List;

/**
 */
public class Checkout {

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";
    private HashMap<String, Double> itemsOnSale = new HashMap<>();

    private HashMap<String, Offer> offers = new HashMap<>();

    public Checkout() {
        itemsOnSale.put(APPLE, 0.60);
        itemsOnSale.put(ORANGE, 0.25);

        offers.put(APPLE, new Buy1Get1Free());
        offers.put(ORANGE, new Buy3ForPriceOf2());
    }



    public Double billItems(List<String> basket) {

        Double total = 0.0;
        int totalApples = 0;
        int totalOranges = 0;

        for(String item: basket) {
            if(itemsOnSale.get(item) != null) {

                if(item.equalsIgnoreCase("Apple")){
                    totalApples += 1;
                } else {
                    totalOranges += 1;
                }
            }
        }

        double totalForApples = offers.get(APPLE).calculatePrice(totalApples, itemsOnSale.get(APPLE));
        double totalForOranges = offers.get(ORANGE).calculatePrice(totalOranges, itemsOnSale.get(ORANGE));
        return totalForApples + totalForOranges;

    }
}
