package com.rit.autocomplete;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestAutoComplete {

//	@Test
//	public void testStringMatch() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};		 
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("Indiana", true);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword==false);
//	}

//	@Test
//	public void testStringMatchIndia() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("India", true);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword);
//	}
//	
//	@Test
//	public void testStringMatchChina() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("China", true);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword);
//	}
//	@Test
//	public void testStringMatchExactMatch() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("China", true);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword==true);
//	}
//	@Test
//	public void testStringMatchExactMatchPartially() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("Chi", true);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword==false);
//	}		
//	@Test
//	public void testStringMatchChiNotExactMatch() {
//		String[] list= {"China","Chochlate","Chin","Chinese","India"};
//		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
//		boolean hasword=autoComplete.hasWord("Chi", false);
//		System.out.println(hasword);
//		Assert.assertTrue(hasword==true);
//	}		
	
	@Test
	public void testAutoComplete() {
		String[] list= {"China","Chochlate","Chin","Chinese","India"};
		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
		List<String> listSufix=autoComplete.getSuffix("Chi");
		System.out.println("Result is");
		for(String str:listSufix){
			System.out.println(str);
		}
		Assert.assertTrue(listSufix.contains("China"));
	}		
	@Test
	public void testAutoCompleteC() {
		String[] list= {"China","Chochlate","Chin","Chinese","India"};
		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
		List<String> listSufix=autoComplete.getSuffix("C");
		System.out.println("Result is");
		for(String str:listSufix){
			System.out.println(str);
		}
		Assert.assertTrue(listSufix.contains("China"));
	}		
	@Test
	public void testAutoCompleteIndia() {
		String[] list= {"China","Chochlate","Chin","Chinese","India"};
		AutoComplete autoComplete= new AutoComplete(Arrays.asList(list));
		List<String> listSufix=autoComplete.getSuffix("India");
		System.out.println("Result is");
		for(String str:listSufix){
			System.out.println(str);
		}
		Assert.assertTrue(listSufix.contains("India"));
	}
}
