package com.rit.kadane;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestSmallestPairinTwoSortedArrays {

	@Test
	public void testGetSmallestPairs() {
		SmallestPairInTwoSortedArray util = new SmallestPairInTwoSortedArray();
		int[] arr1={1,2,3,6,10};
		int[] arr2={1,4,5,7};
		List<String> list=util.getSmallestPairs(arr1, arr2, 5);
		for(String str:list)
		{
			System.out.println(str);
		}
	}

}
