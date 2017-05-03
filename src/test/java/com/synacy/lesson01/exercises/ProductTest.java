package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michael on 5/3/17.
 */
public class ProductTest {
    @Test
    public void setUnitPrice_shouldBeAbleToSetPriceGreaterOrEqualToZero() throws Exception {
        Product product = new Product("sample", 1.0);

        Assert.assertTrue(product.getUnitPrice() >= 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setUnitPrice_shouldThrowExceptionWhenPriceSetBelowZero() throws Exception {
        Product product = new Product("sample", -1.0);
    }

}