package com.rit;

import static org.junit.Assert.*;

import org.junit.Test;

public class HammingCountTest {

	@Test
	public void testHammingcount() {
		HammingDistance hd= new HammingDistance();
		int count=hd.hammingcount(1, 4);
		assertEquals(count,2);

	}

}
