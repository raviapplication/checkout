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
        Assert.assertEquals(till.billItems(basket), 1.45, 0);
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

    @Test
    public void generateReceiptFOrApplesOnOffer() {
        List<String> basket = new ArrayList<>();
        basket.add("Apple");
        basket.add("Apple");
        Assert.assertEquals(till.billItems(basket), 0.60, 0);
    }


    @Test
    public void generateReceiptFOrApples() {
        List<String> basket = new ArrayList<>();
        basket.add("Apple");
        basket.add("Apple");
        basket.add("Apple");
        Assert.assertEquals(till.billItems(basket), 1.20, 0);
    }


    @Test
    public void generateReceiptFOrOrangesOnOffer() {
        List<String> basket = new ArrayList<>();
        basket.add("Orange");
        basket.add("Orange");
        basket.add("Orange");
        Assert.assertEquals(till.billItems(basket), 0.50, 0);
    }


    @Test
    public void generateReceiptFOrLessOranges() {
        List<String> basket = new ArrayList<>();
        basket.add("Orange");
        basket.add("Orange");
        Assert.assertEquals(till.billItems(basket), 0.50 , 0);
    }


}
