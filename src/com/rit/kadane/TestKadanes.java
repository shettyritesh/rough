package com.rit.kadane;


import org.junit.Assert;
import org.junit.Test;

public class TestKadanes {

	@Test
	public void testMain() {
		
		Kadane kadane= new Kadane();
		int[] arr={-2,3,2,-1};
		int maximum=kadane.getMaximumSubarray(arr);
		System.out.println("maximum is "+maximum);
		Assert.assertTrue(5== maximum);
		
	}

	@Test
	public void testSecond() {
		
		Kadane kadane= new Kadane();
		int[] arr={-1,3,-2,5,-6,1};
		int maximum=kadane.getMaximumSubarray(arr);
		System.out.println("maximum is "+maximum);
		Assert.assertTrue(6== maximum);
		
	}	
	
}
