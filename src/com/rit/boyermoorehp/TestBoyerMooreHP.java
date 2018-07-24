package com.rit.boyermoorehp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class TestBoyerMooreHP {

	@Test
	public void testSearch() {
		BoyerMooreHP bm= new BoyerMooreHP();
		int result=bm.search("I am a good boy in my family boy", "boy");
		Assert.assertTrue(result==12);
	}
	@Test
	@Ignore
	public void testSearch1() {
		BoyerMooreHP bm= new BoyerMooreHP();
		int result=bm.search("I am a good in my family boy", "boy");
		Assert.assertTrue(result==25);
	}

}
