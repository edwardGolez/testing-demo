package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by michael on 5/3/17.
 */
public class InvoiceTest {
    @Test
    public void getTotalAmount_shouldReturnDoubleAsTotalOf8() throws Exception {
        HashSet<InvoiceItem> items = new HashSet<InvoiceItem>();

        items.add(new InvoiceItem(new Product("p1", 1.0), 3));
        items.add(new InvoiceItem(new Product("p2", 2.5), 2));

        Invoice invoice = new Invoice(items);

        double result = invoice.getTotalAmount();

        Assert.assertEquals(8, result, 0.001);
    }
}