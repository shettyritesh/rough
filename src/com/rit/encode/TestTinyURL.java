package com.rit.encode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTinyURL {

	@Test
	public void testGetTinyURL() {
		TinyURL util= new TinyURL();
		String encoded=util.getTinyURL("www.google.com");
		System.out.println(encoded);
		String dencoded=util.getURL(encoded);
		System.out.println(dencoded);		
	}

}
