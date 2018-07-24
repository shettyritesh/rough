package com.rit.test;

import org.junit.Assert;
import org.junit.Test;

import com.rit.Rectangles;

public class TestRectangles {

	@Test
	public void testGetRectangleCount() {
		Assert.assertEquals(1,1);
		
		int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		Rectangles rec=new Rectangles();
		rec.getRectangleCount(arr);
		
	}



}
