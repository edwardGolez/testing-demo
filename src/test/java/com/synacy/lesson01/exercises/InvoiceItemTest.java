package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by banjoe on 5/3/17.
 */
public class InvoiceItemTest {

    @Test
    public void getExtendedPrice() throws Exception {
        Product product = new Product("sample product", 500.00);

        InvoiceItem invoiceItem = new InvoiceItem(product, 2);

        double extendedPrice = invoiceItem.getExtendedPrice();
        Assert.assertEquals(1000.00, extendedPrice, 0.001);
    }

}