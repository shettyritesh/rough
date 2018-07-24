package com.rit.median;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class TestMyMedian {

	@Test
	public void testGetMedianNormal() {
		int[]arr1= {1,4,9,26,29,30,71,75};
		int[]arr2= {2,3,8,10,22,25,31,65,72};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(25.0, med);
	}
	@Test
	public void testGetMedianCornerCase() {
		int[]arr1= {20,30,40};
		int[]arr2= {1,2,3,4,5,6,7,8};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(6.0, med);
	}

	@Test
	public void testGetMedianEven() {
		int[]arr1= {2,3,11,12};
		int[]arr2= {5,6,8,9,13,14,17,18,19,20};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(11.5, med);
	}	

	@Test
	public void testGetMedianSmaller() {
		int[]arr1= {1,3};
		int[]arr2= {2};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(2.0, med);
	}
	
	@Test
	public void testGetMedianJust2Each() {
		int[]arr1= {1,2};
		int[]arr2= {3,4};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(2.5, med);
	}	
	@Test
	public void testGetMedianEmpty() {
		int[]arr1= {};
		int[]arr2= {2,3};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(2.5, med);
	}
	@Test
	public void testGetMedianOneEach() {
		int[]arr1= {1000};
		int[]arr2= {1001};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(1000.5, med);
	}
	@Test
	public void testGetMedianSingleSecond() {
		int[]arr1= {1,2,3,5,6};
		int[]arr2= {4};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(3.5, med);
	}
	@Test
	public void testGetMedianSmallFirst() {
		int[]arr1= {3,4,5,6,7,8};
		int[]arr2= {1,2};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(4.5, med);
	}	
	@Test
	public void testGetMedianEmpty2() {
		int[]arr1= {};
		int[]arr2= {1,2,3,4,5};
		MyMedian median= new MyMedian();
		double med=median.getMedian(arr1, arr2);
		Assert.assertEquals(3.0, med);
	}	
}
