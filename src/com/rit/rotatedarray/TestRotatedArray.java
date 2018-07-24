package com.rit.rotatedarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRotatedArray {

	@Test
	public void testGetStartIndex() {
		RotatedArrayUtil util= new RotatedArrayUtil();
		int[] arr={5,6,7,8,1,2,3,4};
		int index=util.getStartIndex(arr,8);
		assertEquals(index, 3);
		
	}
	@Test
	public void testGetStartIndex1() {
		RotatedArrayUtil util= new RotatedArrayUtil();
		int[] arr={8,1,2,3,4};
		int index=util.getStartIndex(arr,8);
		assertEquals(index, 0);
		
	}
	@Test
	public void testGetStartIndex2() {
		RotatedArrayUtil util= new RotatedArrayUtil();
		int[] arr={1,2,3,4,5,6,7,8};
		int index=util.getStartIndex(arr,8);
		assertEquals(index, 7);
		
	}
	@Test
	public void testGetStartIndex3() {
		RotatedArrayUtil util= new RotatedArrayUtil();
		int[] arr={1,2,3,4,5,6,7,8};
		int index=util.getStartIndex(arr,18);
		assertEquals(index, -1);
		
	}	
//4,5,6,7,8,1,2,3
}
