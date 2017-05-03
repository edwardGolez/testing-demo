package com.synacy.lesson01.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

	@Test
	public void contains_shouldReturnTrueIfGivenNumberIsInArray() throws Exception  {

		int[] array = new int[]{3, 4, 5, 6, 7, 8};
		int target = 6;

		boolean result = ArrayUtils.contains(array, target);

		assertEquals(true, result);
	}

	@Test
	public void contains_shouldReturnFalseIfGivenNumberIsNotInArray() throws Exception  {

		int[] array = new int[]{3, 4, 5, 6, 7, 8};
		int target = 9;

		boolean result = ArrayUtils.contains(array, target);

		assertEquals(false, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void elementAt_shouldThrowIllegalArgumentExceptionIfIndexIsNotWithinRange() throws Exception {

		int[] array = new int[]{3, 4, 5, 6, 7, 8};
		int index = -1;

		ArrayUtils.elementAt(array, index);
	}

	@Test
	public void sort_shouldSortGivenArray() throws Exception {
		int[] array = { 5, -2, 3, -4, 6, 0};
		int[] sortedArray = {-4, -2, 0, 3, 5, 6};

		ArrayUtils.sort(array);

		assertArrayEquals(sortedArray, array);
	}

}