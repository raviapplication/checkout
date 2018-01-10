package com.shop.offers;

/**
 * Created by santoshkasar on 10/01/18.
 */
public class Buy1Get1Free implements Offer{

    public int getOfferFactor() {
        return 2;
    }

    @Override
    public int getOfferMultiplier() {
        return 1;
    }

    public double calculatePrice(int quantity, double unitPrice) {

        if(quantity == 0) {
            return 0.0;
        }
        double total = ((quantity % this.getOfferFactor()) * unitPrice)
                + (quantity / this.getOfferFactor()) * unitPrice * this.getOfferMultiplier();

        return total;
    }
}
