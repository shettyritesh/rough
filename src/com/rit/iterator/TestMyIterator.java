package com.rit.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestMyIterator {

	@Test
	public void testMyIteratorNkowHow() {
		Integer[] arr= {1,2,3};
		MyIteratorNkowHow<Integer> myiter= new MyIteratorNkowHow<Integer>(arr);
		Iterator<Integer> it=myiter.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
	}

}
