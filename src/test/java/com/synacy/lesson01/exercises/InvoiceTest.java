package com.synacy.lesson01.exercises;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class InvoiceTest {
    @Test
    public void getTotalAmount_shouldResultToTotalOfInvoiceItems() throws Exception {
        Set<InvoiceItem> items = new HashSet<>();
        items.add(new InvoiceItem(new Product("apple", 10.00), 3));
        items.add(new InvoiceItem(new Product("orange", 5.00), 6));
        items.add(new InvoiceItem(new Product("kaimito", 8.00), 5));

        Invoice invoice = new Invoice(items);
        double totalAmount = invoice.getTotalAmount();

        assertEquals(100.00, totalAmount, 0.01);
    }

}