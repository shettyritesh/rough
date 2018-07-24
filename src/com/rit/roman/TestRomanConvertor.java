package com.rit.roman;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestRomanConvertor {

	@Test	public void testToRomanEleven() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(11);
		System.out.println("Roman: "+str);
		Assert.assertTrue("XI".equals(str));
	}
	@Test	public void testToRomanNineTeen() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(19);
		System.out.println("Roman: "+str);
		Assert.assertTrue("XIX".equals(str));
	}
	@Test	public void testToRomanOneThousandOne() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(1001);
		System.out.println("Roman: "+str);
		Assert.assertTrue("MI".equals(str));
	}
	@Test	public void testToRomanNineEightyTwo() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(982);
		System.out.println("Roman: "+str);
		Assert.assertTrue("CMLXXXII".equals(str));
	}
	@Test	public void testToRomanFiftyfive() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(55);
		System.out.println("Roman: "+str);
		Assert.assertTrue("LV".equals(str));
	}
	@Test	public void testToRomanEightyfive() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(85);
		System.out.println("Roman: "+str);
		Assert.assertTrue("LXXXV".equals(str));
	}
	@Test	public void testToRomanFive() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(5);
		System.out.println("Roman: "+str);
		Assert.assertTrue("V".equals(str));
	}
	@Test	public void testToRomanTen() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(10);
		System.out.println("Roman for Ten: "+str);
		Assert.assertTrue("X".equals(str));
	}
	@Test	public void testToRomanHundred() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(100);
		System.out.println("Roman for Hundred: "+str);
		Assert.assertTrue("C".equals(str));
	}	
	@Test	public void testToRoman3999() {
		RomanConvertor util= new RomanConvertor();
		String str=util.toRoman(3999);
		System.out.println("Roman for 3999: "+str);
		Assert.assertTrue("MMMCMXCIX".equals(str));
	}
}
