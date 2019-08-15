package com.srikanth.fullstackjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.srikanth.fullstackjava.ArraySort;

public class ArraySortTest {

	@Test
	public void test() {
		ArraySort as = new ArraySort();
		int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
		int[] inputArray = {4, 1, 9, 8, 2, 5, 7, 3, 6};
		assertArrayEquals(expectedArray, as.sortNumbers(inputArray));
	}

}
