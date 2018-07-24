package com.rit.totalnegative;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestTotalNegativeNumbers {

	@Test
	public void testGettotalNegativeNumbers() {
		int[][]arr={{-3,-2,-1,1},{-2,3,4,5},{4,5,7,9}};
		
		FindTotalNegativeNumbers util= new FindTotalNegativeNumbers();
		int total=util.gettotalNegativeNumbers(arr);
		Assert.assertTrue(total==4);
	}

}
