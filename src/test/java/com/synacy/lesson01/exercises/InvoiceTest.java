package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kenichigouang on 5/3/17.
 */
public class InvoiceTest {
    @Test
    public void getTotalAmount_shouldReturn225AtBaconAt12At10UnitsAndSiomaiAt7At15Units() throws Exception {
        Set<InvoiceItem> items = new HashSet<>();

        items.add(new InvoiceItem(new Product("bacon", 12.0), 10));
        items.add(new InvoiceItem(new Product("siomai", 7.0), 15));

        Invoice invoice = new Invoice(items);
        double result = invoice.getTotalAmount();

        Assert.assertEquals(225, result, .001);

    }

}