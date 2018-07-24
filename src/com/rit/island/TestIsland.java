package com.rit.island;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsland {

	@Test
	public void test() {
		int[][] arr= {{1,1,1,0,0,0,1,0},
					  {0,0,1,0,1,1,1,1},
					  {0,1,1,0,0,0,1,0},
					  {0,0,0,0,1,0,0,0},
					  {0,0,1,1,0,0,0,1},
					  {0,0,0,1,1,1,0,1},
					  {0,0,0,1,1,1,0,0},
					  {0,0,0,0,0,0,1,0}};
		Maps maps= new Maps(arr);
		maps.printIslands();
	}

}
