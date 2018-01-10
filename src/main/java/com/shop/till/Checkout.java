package com.shop.till;

import com.shop.offers.Buy1Get1Free;
import com.shop.offers.Buy3ForPriceOf2;

import java.util.HashMap;
import java.util.List;

/**
 */
public class Checkout {

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";
    private HashMap<String, Double> itemsOnSale = new HashMap<>();

    private HashMap<String, Integer> offerFactors = new HashMap<>();

    public Checkout() {
        itemsOnSale.put(APPLE, 0.60);
        itemsOnSale.put(ORANGE, 0.25);

        offerFactors.put(APPLE, new Buy1Get1Free().getOfferFactor());
        offerFactors.put(ORANGE, new Buy3ForPriceOf2().getOfferFactor());
    }



    public Double billItems(List<String> basket) {

        Double total = 0.0;
        int totalApples = 0;
        int totalOranges = 0;

        for(String item: basket) {
            if(itemsOnSale.get(item) != null) {

                if(item.equalsIgnoreCase(APPLE)){
                    totalApples += 1;
                } else {
                    totalOranges += 1;
                }
            }
        }

        double totalForApples = ((totalApples % offerFactors.get(APPLE)) * itemsOnSale.get(APPLE))
                                    + (totalApples / offerFactors.get(APPLE)) * itemsOnSale.get(APPLE);
        double totalForOranges = ((totalOranges % offerFactors.get(ORANGE)) * itemsOnSale.get(ORANGE))
                                    + (totalOranges / offerFactors.get(ORANGE) ) * itemsOnSale.get(ORANGE) *2;
        return totalForApples + totalForOranges;

    }
}
