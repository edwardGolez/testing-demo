package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by banjoe on 5/3/17.
 */
public class ComplexNumberTest {

    ComplexNumber complexNumber;

    @Before
    public void init() throws Exception {
        complexNumber = new ComplexNumber(10.50, 20.10);
    }

    @Test
    public void add_shouldReturnSumOfRealAndImaginaryByBothComplexNumber() throws Exception {
        ComplexNumber anotherComplexNumber = new ComplexNumber(20.50, 10);
        ComplexNumber result = complexNumber.add(anotherComplexNumber);

        Assert.assertEquals(31, result.getReal(), 0.001);
        Assert.assertEquals(30.1, result.getImaginary(), 0.001);
    }

    @Test
    public void subtract_shouldReturnDifferenceOfRealAndImaginaryByBothComplexNumber() throws Exception {
        ComplexNumber anotherComplexNumber = new ComplexNumber(5.50, 10.10);
        ComplexNumber result = complexNumber.subtract(anotherComplexNumber);

        Assert.assertEquals(5, result.getReal(), 0.001);
        Assert.assertEquals(10, result.getImaginary(), 0.001);
    }

    @Test
    public void multiply_shouldReturnProductOfRealAndImaginaryByBothComplexNumber() throws Exception {
        ComplexNumber anotherComplexNumber = new ComplexNumber(5.50, 10.10);
        ComplexNumber result = complexNumber.multiply(anotherComplexNumber);

        Assert.assertEquals(-145.26, result.getReal(), 0.001);
        Assert.assertEquals(216.6, result.getImaginary(), 0.001);
    }

}