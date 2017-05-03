package com.synacy.lesson01.exercises;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ComplexNumberTest {
    ComplexNumber complexNumber1;
    ComplexNumber complexNumber2;
    ComplexNumber expectedComplexNumber;

    @Before
    public void setup(){
        complexNumber1 = new ComplexNumber(5.0,3.0);
        complexNumber2 = new ComplexNumber(2.0,2.0);
    }
    @Test
    public void add_shouldGetExpectedComplexNumberReal() throws Exception {
        expectedComplexNumber = new ComplexNumber(7.0,5.0);
        ComplexNumber actualComplexNumber = complexNumber1.add(complexNumber2);
        assertEquals(expectedComplexNumber.getReal(), actualComplexNumber.getReal(),0.00001);
    }
    @Test
    public void add_shouldGetExpectedComplexNumberImaginary() throws Exception {
        expectedComplexNumber = new ComplexNumber(7.0,5.0);
        ComplexNumber actualComplexNumber = complexNumber1.add(complexNumber2);
        assertEquals(expectedComplexNumber.getImaginary(), actualComplexNumber.getImaginary(),0.00001);
    }

    @Test
    public void subtract_shouldGetExpectedComplexNumberReal() throws Exception {
        expectedComplexNumber = new ComplexNumber(3.0,1.0);
        ComplexNumber actualComplexNumber = complexNumber1.subtract(complexNumber2);
        assertEquals(expectedComplexNumber.getReal(), actualComplexNumber.getReal(),0.00001);
    }

    @Test
    public void subtract_shouldGetExpectedComplexNumberImaginary() throws Exception {
        expectedComplexNumber = new ComplexNumber(3.0,1.0);
        ComplexNumber actualComplexNumber = complexNumber1.subtract(complexNumber2);
        assertEquals(expectedComplexNumber.getImaginary(), actualComplexNumber.getImaginary(),0.00001);
    }

    @Test
    public void multiply_shouldGetExpectedComplexNumberReal() throws Exception {
        expectedComplexNumber = new ComplexNumber(4.0,16.0);
        ComplexNumber actualComplexNumber = complexNumber1.multiply(complexNumber2);
        assertEquals(expectedComplexNumber.getReal(), actualComplexNumber.getReal(),0.00001);
    }

    @Test
    public void multiply_shouldGetExpectedComplexNumberImaginary() throws Exception {
        expectedComplexNumber = new ComplexNumber(4.0,16.0);
        ComplexNumber actualComplexNumber = complexNumber1.multiply(complexNumber2);
        assertEquals(expectedComplexNumber.getImaginary(), actualComplexNumber.getImaginary(),0.00001);
    }

}