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
    public void subtract() throws Exception {
        Assert.fail();
    }

    @Test
    public void multiply() throws Exception {
        Assert.fail();
    }

}