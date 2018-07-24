package com.rit.floodfill;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFloodFill {

	@Test
	public void testFloodFill() {
		char[][] thatBitmap= {{'#','#','#','#','#','#','_','#','#','#'},
							  {'#','_','#','_','#','_','#','_','_','_'},
							  {'#','_','#','_','#','_','_','_','_','_'},
							  {'#','_','#','#','#','#','#','#','#','#'},
							  {'#','#','#','#','_','#','_','_','_','_'}};
		
		FloodFill ff= new FloodFill(thatBitmap);
		ff.printBitMap();
		ff.floodFill(4, 9, '#');
		System.out.println();
		System.out.println();
		System.out.println();
		ff.printBitMap();
	}

}
