package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test(expected = IllegalArgumentException.class)
    public void setUnitPrice_shouldThrowAnIllegalArgumentExceptionWhenSettingInvalidPrice() throws Exception {
        Product product = new Product("dunotNgaApple", -1.00);

        product.setUnitPrice(-1.00);
    }

}