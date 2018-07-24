package com.rit.binaryconvertor;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestBinaryConvertor {

	@Test
	public void testConvertToBinary() {
		BinaryConvertor conv= new BinaryConvertor();
		String ans=conv.convertToBinary((float)13.79);
		assertTrue(ans.equals("01000001010111001010001111010111"));

	}
	
	@Test
	public void testConvertIntToBinary() {
		BinaryConvertor conv= new BinaryConvertor();
		String ans=conv.convertToBinary(13);
		assertTrue(ans.equals("01000001010100000000000000000000"));

	}
	@Test
	public void testConvertIntToBinaryFunc() {
		BinaryConvertor conv= new BinaryConvertor();
		String ans=conv.getIntegerToBinary(124);
		assertTrue(ans.equals(Integer.toBinaryString(124)));

	}		
	@Test
	public void testConvertToBinaryNegative() {
		BinaryConvertor conv= new BinaryConvertor();
		String ans=conv.convertToBinary((float)-13.79);
		System.out.println("ans is "+ans);
		System.out.println("exp is 11000001010111001010001111010111");
		assertTrue(ans.equals("11000001010111001010001111010111"));

	}
}
