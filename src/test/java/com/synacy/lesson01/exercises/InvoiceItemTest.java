package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceItemTest {
    @Test
    public void getExtendedPrice_shouldGet10WhenGivenUnitPrice2Quantity5() throws Exception {
        Product product = new Product("Gum", 2.0);
        InvoiceItem invoiceItem = new InvoiceItem(product,5);
        assertEquals(10,invoiceItem.getExtendedPrice(), 0.00001);
    }

}