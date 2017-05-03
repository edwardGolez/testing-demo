package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by michael on 5/3/17.
 */
public class ComplexNumberTest {
    @Test
    public void add_shouldRea() throws Exception {
        ComplexNumber complex = new ComplexNumber(1, 5);
        ComplexNumber anotherComplex = new ComplexNumber(2.1, 1.5);


        ComplexNumber sum = complex.add(anotherComplex);

        this.assertComplexNumberContains(3.1, 6.5, sum);
    }


    @Test
    public void subtract_shouldReturnComplexNumberInstanceAsTheDifference() throws Exception {
        ComplexNumber complex = new ComplexNumber(10.5, 3.3);
        ComplexNumber anotherComplex = new ComplexNumber(3, 1.1);

        ComplexNumber diff = complex.subtract(anotherComplex);

        this.assertComplexNumberContains(7.5, 2.2, diff);
    }

    @Test
    public void multiply_shouldReturnComplexNumberInstanceAsProduct() throws Exception {
        ComplexNumber complex = new ComplexNumber(8, 0);
        ComplexNumber anotherComplex = new ComplexNumber(8, 0);

        ComplexNumber product = complex.multiply(anotherComplex);

        this.assertComplexNumberContains(64, 0, product);
    }

    private void assertComplexNumberContains(double real, double imaginary, ComplexNumber actual) {
        double delta = 0.001;

        Assert.assertEquals(real, actual.getReal(), delta);
        Assert.assertEquals(imaginary, actual.getImaginary(), delta);
    }
}