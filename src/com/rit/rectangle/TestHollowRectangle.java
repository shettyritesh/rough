package com.rit.rectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHollowRectangle {

	@Test
	public void testPrintRectangles() {
		int[][] arr= 
				  {
				  {1,1,1,0,1,0,0,0},
				  {1,0,1,0,1,0,0,0},
				  {1,1,1,0,1,0,0,0},
				  {0,0,0,0,1,0,0,0},
				  {0,0,0,0,0,0,0,0},
				  {0,0,0,0,0,0,0,0},
				  {0,1,1,1,0,1,1,1},
				  {0,1,1,1,0,0,0,0}};

		HollowRectangle rect= new HollowRectangle(arr);
		rect.printRectangles();
	}

}
