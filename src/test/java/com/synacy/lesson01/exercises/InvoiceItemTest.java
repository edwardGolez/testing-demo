package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michael on 5/3/17.
 */
public class InvoiceItemTest {

    @Test
    public void getExtendedPrice_shouldReturnDouble20() throws Exception {
        InvoiceItem item = new InvoiceItem();

        item.setProduct(new Product("sample", 10.0));
        item.setQuantity(2);

        Assert.assertEquals(20, item.getExtendedPrice(), 0.001);
    }
}