package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kenichigouang on 5/3/17.
 */
public class InvoiceItemTest {
    @Test
    public void getExtendedPrice_shouldReturn1000() throws Exception {
        Product product = new Product("Steak", 100.0);
        int quantity = 10;

        InvoiceItem invoiceItem = new InvoiceItem(product, quantity);

        double result = invoiceItem.getExtendedPrice();

        Assert.assertEquals(1000, result, .001);
    }

}