package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test(expected = IllegalArgumentException.class)
    public void setUnitPrice_shouldThrowIllegalArgumentExceptionWhenUnitPriceIsLessThanZero() throws Exception {
        Product product = new Product("new product", -1.0);
    }

}