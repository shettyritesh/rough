package com.rit.median;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestMedian {

	@Test
	public void testGetMedian() {
		int[] arr={6,1,5,17,3,12,2};
		Median med= new Median(arr);
		double ans=med.getMedian();
		System.out.println(ans);
		Assert.assertTrue(ans==5.0);
	}

}
