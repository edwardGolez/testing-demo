package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {

    @Test
    public void add_shouldAddTwoComplexNumbersAndReturnAComplexNumber() throws Exception {
        ComplexNumber number = new ComplexNumber(3, -1);
        ComplexNumber anotherComplexNumber = new ComplexNumber(4, -1);

        ComplexNumber result = number.add(anotherComplexNumber);

        assertEquals(7, result.getReal(), 0.001);
        assertEquals(-2, result.getImaginary(), 0.001);
    }

    @Test
    public void subtract_shouldSubtractTwoComplexNumbersAndReturnAComplexNumber() throws Exception {
        ComplexNumber number = new ComplexNumber(4, -1);
        ComplexNumber anotherComplexNumber = new ComplexNumber(7, -1);

        ComplexNumber result = number.subtract(anotherComplexNumber);

        assertEquals(-3, result.getReal(), 0.001);
        assertEquals(0, result.getImaginary(), 0.001);
    }

    @Test
    public void multiply_shouldMultiplyTwoComplexNumbersAndReturnAComplexNumber() throws Exception {
        ComplexNumber number = new ComplexNumber(5, -1);
        ComplexNumber anotherComplexNumber = new ComplexNumber(3, -1);

        ComplexNumber result = number.multiply(anotherComplexNumber);

        assertEquals(15, result.getReal(), 0.001);
        assertEquals(1, result.getImaginary(), 0.001);
    }

}