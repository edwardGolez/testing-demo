package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class InvoiceTest {

    @Test
    public void getTotalAmount_shouldReturnTotalAmountOfAllItemsInTheInvoice() throws Exception {
        Product product = new Product("sample product", 200.00);
        InvoiceItem invoiceItem = new InvoiceItem(product, 2);

        Set<InvoiceItem> items = new HashSet<>();
        items.add(invoiceItem);

        Invoice invoice = new Invoice(items);

        double totalAmount = invoice.getTotalAmount();

        Assert.assertEquals(400.00, totalAmount, 0.001);
    }

}