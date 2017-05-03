package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kenichigouang on 5/3/17.
 */
public class ComplexNumberTest {
    @Test
    public void add_ShouldReturn5Real4ImaginaryComplexNumber() throws Exception {
        ComplexNumber complexNumber = new ComplexNumber(2, 4);
        ComplexNumber anotherComplexNumber = new ComplexNumber(3, 0);

        ComplexNumber result = complexNumber.add(anotherComplexNumber);

        Assert.assertEquals(new ComplexNumber(5,4), result);
    }

    @Test
    public void subtract() throws Exception {
    }

    @Test
    public void multiply() throws Exception {
    }

}