package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test(expected = IllegalArgumentException.class)
    public void product_shouldThrowIllegalArgumentException() throws Exception {
        Product product = new Product("Gum",-5.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setUnitPrice_shouldThrowIllegalArgumentException() throws Exception {
        Product product = new Product("Gum",5.0);
        product.setUnitPrice(-1.0);
    }

}