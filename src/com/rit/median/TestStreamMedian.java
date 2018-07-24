package com.rit.median;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestStreamMedian {

	@Test
	public void testGetCurrentMedian() {
		StreamMedian smedian= new StreamMedian();
		double d=smedian.getCurrentMedian(4);
		Assert.assertEquals(4.0, d);
	}
	@Test
	public void testGetCurrentMedian1() {
		StreamMedian smedian= new StreamMedian();
		smedian.getCurrentMedian(4);
		double d=smedian.getCurrentMedian(5);
		Assert.assertEquals(4.5, d);
	}
	
	@Test
	public void testGetCurrentMedian2() {
		StreamMedian smedian= new StreamMedian();
		smedian.getCurrentMedian(4);
		smedian.getCurrentMedian(5);
		double d=smedian.getCurrentMedian(15);
		Assert.assertEquals(5.0, d);
	}
	@Test
	public void testGetCurrentMedian3() {
		StreamMedian smedian= new StreamMedian();
		smedian.getCurrentMedian(4);
		smedian.getCurrentMedian(5);
		smedian.getCurrentMedian(71);
		double d=smedian.getCurrentMedian(15);
		Assert.assertEquals(10.0, d);
	}		
}
