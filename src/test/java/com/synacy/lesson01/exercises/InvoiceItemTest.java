package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceItemTest {
    @Test
    public void getExtendedPrice_shouldResultToTheProductOfPriceAndQuantity() throws Exception {
        InvoiceItem item = new InvoiceItem(new Product("apple", 10.00), 3);

        double extendedPrice = item.getExtendedPrice();

        assertEquals(30.00, extendedPrice, 0.01);
    }

}