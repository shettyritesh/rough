package com.rit.palamdrom;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestPalamdrome {

	@Test
	public void testCheck1() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(util.check("ABA"));
	}

	@Test
	public void testCheck2() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(util.check("AAB"));
	}

	@Test
	public void testCheck3() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(util.check("ABAB"));
	}
	@Test
	public void testCheck4() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(util.check("civic"));
	}

	@Test
	public void testCheck5() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(util.check("ivicc"));
	}

	@Test
	public void testCheck6() {
		CheckPermutationisPlamdrom util= new CheckPermutationisPlamdrom();
		Assert.assertTrue(!util.check("civil"));
	}	
}
