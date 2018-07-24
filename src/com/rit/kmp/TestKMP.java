package com.rit.kmp;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestKMP {

//	@Test
//	public void testbrutForceSearch() {
//		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
//		int index=knuthMorrisPratt.brutForceSearch("I am a good boy", "good");
//		System.out.println("Index is ="+index);
//		assertEquals(7,index);
//
//		
//	}
//
//	@Test
//	public void testbrutForceSearchNonMatching() {
//		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
//		int index=knuthMorrisPratt.brutForceSearch("I am a good boy", "girl");
//		System.out.println("Index is ="+index);
//		assertEquals(-1,index);
//
//		
//	}
	
	@Test
	public void testKMPSearch() {
		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
		int index=knuthMorrisPratt.search("I am a good boy", "good");
		System.out.println("Index is ="+index);
		assertEquals(7,index);

		
	}	

	@Test
	public void testKMPSearch1() {
		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
		int index=knuthMorrisPratt.search("ABCEFGXSABCEFGH1", "BCEFGH");
		System.out.println("Index is ="+index);
		assertEquals(9,index);

		
	}	
	@Test
	public void testKMPSearch2() {
		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
		int index=knuthMorrisPratt.search("ABCEFGXSABCEFGH", "BCEFGH");
		System.out.println("Index is ="+index);
		assertEquals(9,index);
		
	}
	
	@Test
	public void testKMPSearch3() {
		KnuthMorrisPratt knuthMorrisPratt= new KnuthMorrisPratt();
		int index=knuthMorrisPratt.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY");
		System.out.println("Index is ="+index);
		assertEquals(15,index);
		
	}		
}
