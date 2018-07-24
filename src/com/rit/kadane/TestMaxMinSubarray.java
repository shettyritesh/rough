package com.rit.kadane;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestMaxMinSubarray {

	@Test
	public void testGetCountOfMaxMinusMinSubarray() {
		int arr[]={2,6,18,27,28};
		MaxMinusMinSubarray util= new MaxMinusMinSubarray();
		int total=util.getCountOfMaxMinusMinSubarray(arr, 15);
		System.out.println(total);
		Assert.assertTrue(total==2);
	}

}
