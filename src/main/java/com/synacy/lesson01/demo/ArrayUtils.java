package com.synacy.lesson01.demo;

public class ArrayUtils {

	public static boolean contains(int[] array, int target) {

		for (int element : array) {
			if (element == target) {
				return true;
			}
		}

		return false;
	}

	public static int elementAt(int[] array, int index) {
		if (index < 0 || index >= array.length) {
			throw new IllegalArgumentException("Invalid index for array of length " + array.length + ": " + index);
		}

		return array[index];
	}

	public static void sort(int[] array) {
		int arrayLength = array.length;
		int temp = 0;

		for (int i = 0; i < arrayLength; i++) {
			for (int j = 1; j < (arrayLength - i); j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
	}

}
