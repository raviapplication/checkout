package com.shop.offers;

/**
 * Created by santoshkasar on 10/01/18.
 */
public interface Offer {

    int getOfferFactor();
    int getOfferMultiplier();
    double calculatePrice(int quantity, double unitPrice);
}
