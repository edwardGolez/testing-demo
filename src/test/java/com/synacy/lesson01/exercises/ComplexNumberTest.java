package com.synacy.lesson01.exercises;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.fail;

/**
 * Created by kenichigouang on 5/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ComplexNumberTest {
    @Test
    public void add_shouldReturn5Real4ImaginaryComplexNumber() throws Exception {
        ComplexNumber complexNumber = new ComplexNumber(2, 4);
        ComplexNumber anotherComplexNumber = new ComplexNumber(3, -2);

        ComplexNumber result = complexNumber.add(anotherComplexNumber);

        Assert.assertEquals(5, result.getReal(), .001);
        Assert.assertEquals(2, result.getImaginary(), .001);
    }

    @Test
    public void subtract_shouldReturn2Real6ImaginaryComplexNumber() throws Exception {
        ComplexNumber complexNumber = new ComplexNumber(5, 4);
        ComplexNumber anotherComplexNumber = new ComplexNumber(3, -2);

        ComplexNumber result = complexNumber.subtract(anotherComplexNumber);

        Assert.assertEquals(2, result.getReal(), .001);
        Assert.assertEquals(6, result.getImaginary(), .001);
    }

    @Test
    public void multiply_shouldReturn3Real8iSquaredReal12Imaginary2Imaginary() throws Exception {
        ComplexNumber complexNumber = new ComplexNumber(3, 2);
        ComplexNumber anotherComplexNumber = new ComplexNumber(1, 4);

        ComplexNumber result = complexNumber.multiply(anotherComplexNumber);

        Assert.assertEquals(-5, result.getReal(), .001);
        Assert.assertEquals( 14, result.getImaginary(), .001);

    }

}