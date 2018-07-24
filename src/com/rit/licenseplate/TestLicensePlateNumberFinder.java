package com.rit.licenseplate;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class TestLicensePlateNumberFinder {

	@Test
	public void testGetString() {
		LicensePlateNumberFinder finder= new LicensePlateNumberFinder();
		Set<String> strings= new HashSet<String>();
		strings.add("HELP");
		strings.add("CARS");
		strings.add("CAR");
		strings.add("MARS");
		strings.add("CRYAYON");
		strings.add("");
		finder.addDictionaries(strings);
		String resl=finder.getString("R10C");
		Assert.assertEquals("CAR", resl);
	}
	@Test
	public void testGetString2() {
		LicensePlateNumberFinder finder= new LicensePlateNumberFinder();
		Set<String> strings= new HashSet<String>();
		strings.add("HELP");
		strings.add("CARS");
		strings.add("CAR");
		strings.add("MARS");
		strings.add("CRYAYON");
		strings.add("");
		finder.addDictionaries(strings);
		String resl=finder.getString("H1PC");
		Assert.assertEquals("", resl);
	}
}
