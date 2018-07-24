package com.rit.numbertotext;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class TestNumberReader {

//	@Test
//	public void testGetText() {
//		NumberReader reader= new NumberReader();
//		String str=reader.getText(15);
//		Assert.assertTrue("Fifteen".equals(str));
//	}
//	@Test
//	public void testGetText1() {
//		NumberReader reader= new NumberReader();
//		String str=reader.getText(25);
//		Assert.assertTrue("Twenty Five".equals(str));
//	}
//	@Test
//	public void testGetText2() {
//		NumberReader reader= new NumberReader();
//		String str=reader.getText(11);
//		Assert.assertTrue("Eleven".equals(str));
//	}
//	@Test
//	public void testGetText3() {
//		NumberReader reader= new NumberReader();
//		String str=reader.getText(111);
//		Assert.assertTrue("One Hundred Eleven".equals(str));
//	}
	@Test
	public void testGetText4() {
		NumberReader reader= new NumberReader();
		String str=reader.getText(100);
		Assert.assertTrue("One Hundred".equals(str.trim()));
	}	
	@Test
	public void testGetText5() {
		NumberReader reader= new NumberReader();
		String str=reader.getText(100351);
		Assert.assertTrue("One Hundred Thousand Three Hundred Fifty One".equals(str));
	}	
	@Test
	public void testGetText6() {
		NumberReader reader= new NumberReader();
		String str=reader.getText(1000100);
		System.out.println(str);
		Assert.assertTrue("One Million One Hundred".equals(str.trim()));
	}	
	@Test
	public void testGetText7() {
		NumberReader reader= new NumberReader();
		String str=reader.getText(10001000100L);
		System.out.println(str);
		Assert.assertTrue("Ten Billion One Million One Hundred".equals(str.trim()));
	}	

}
