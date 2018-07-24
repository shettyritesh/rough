package com.rit.square;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestSquare {

	@Test
	public void testfindSquare() {
		int[][] arr = { { 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 0, 0, 1, 1, 1 }, 
						{ 0, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 0, 0, 0, 0 }, 
						{ 1, 1, 1, 0, 1, 0, 0, 0 },
						{ 1, 1, 1, 0, 0, 1, 0, 0 }, 
						{ 1, 1, 1, 0, 0, 0, 0, 0 } };
		Square square = new Square(arr);
		square.findMaxSquare();
	}
	
	@Test	
	@Ignore
	public void testMin(){
		int ans=Square.min(1, 1, 1);
		System.out.println(ans);
	}

}
