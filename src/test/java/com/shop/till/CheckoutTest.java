package com.shop.till;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by santoshkasar on 10/01/18.
 */
public class CheckoutTest {
    Checkout till = new Checkout();
    @Before
    public void setUpCheckout() {
        
    } 
    
    @Test
    public void generateReceipt() {
        List<String> basket = new ArrayList<>();
        basket.add("Apple");
        basket.add("Apple");
        basket.add("Orange");
        basket.add("Apple");
        Assert.assertEquals(till.billItems(basket), 2.05, 0);
    }

    @Test
    public void generateReceiptWithIncorrectItems() {
        List<String> basket = new ArrayList<>();
        basket.add("Applo");
        basket.add("Appleo");
        basket.add("Orange0");
        basket.add("Appleo");
        Assert.assertEquals(till.billItems(basket), 0, 0);

    }

    @Test
    public void generateReceiptWithSomeIncorrectItems() {
        List<String> basket = new ArrayList<>();
        basket.add("Apple");
        basket.add("Appleo");
        basket.add("Orange");
        basket.add("Orengo");
        Assert.assertEquals(till.billItems(basket), 0.85, 0);

    }

}
