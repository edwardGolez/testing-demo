package com.synacy.lesson01.exercises;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by steven on 5/3/17.
 */
public class InvoiceTest {

    @Test
    public void getTotalAmount() throws Exception {
        Product product1 = new Product("Gum",2.0);
        Product product2 = new Product("Candy",1.0);

        InvoiceItem invoiceItem1 = new InvoiceItem(product1,10);
        InvoiceItem invoiceItem2 = new InvoiceItem(product2,15);

        Set<InvoiceItem> items = new HashSet<>();
        items.add(invoiceItem1);
        items.add(invoiceItem2);

        Invoice invoice = new Invoice(items);

        assertEquals(35, invoice.getTotalAmount(), 0.00001);
    }

}