package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by kenichigouang on 5/3/17.
 */
public class ProductTest {
    @Test(expected = IllegalArgumentException.class)
    public void setUnitPrice_shouldThrowIllegalArgumentExceptionAtUnitPriceNeg1() throws Exception {
        Product product = mock(Product.class);
        double unitPrice = -1;

        product.setUnitPrice(unitPrice);
    }

}