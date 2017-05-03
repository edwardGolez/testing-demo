package com.synacy.lesson01.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ccomision on 5/3/17.
 */
public class ComplexNumberTest {

    @Test
    public void add() throws Exception {
        ComplexNumber number = new ComplexNumber(3, -1);

        ComplexNumber result = number.add(number);

        assertEquals(6, result.getReal(), 0.001);
        assertEquals(-2, result.getImaginary(), 0.001);
    }

    @Test
    public void subtract() throws Exception {
        assertTrue(true);
    }

    @Test
    public void multiply() throws Exception {
        assertTrue(true);
    }

}