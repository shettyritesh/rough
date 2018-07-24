package com.rit.rectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRectangle {

	 @Test
	 public void testfindMaxRectangle(){
	 int[][] arr={{0,0,1,0,0,1,0,0},
			 	  {0,0,1,1,1,1,0,0},
			 	  {1,1,1,1,1,1,1,0}};
	 Rectangle rectangle= new Rectangle(arr);
	 int result=rectangle.findMaxRectangle();
	 System.out.println(result);
	 }	

}
