package com.rit.treasurehunt;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreasureHuntTest {

	@Test
	public void testGetDirections() {
		String[][] arr={
					{"","","","","","X"},
					{"","","","","X","$"},
					{"","","","X","",""},
					{"","","","","",""}};
		Point p= null;
		TreasureHunt util= new TreasureHunt();
		util.getDirections(arr,p);
	}

}
