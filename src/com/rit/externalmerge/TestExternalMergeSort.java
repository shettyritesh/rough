package com.rit.externalmerge;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestExternalMergeSort {

	@Test
	public void testSort() {
		ExternalMergeSorter sorter= new ExternalMergeSorter(15);
		try {
			sorter.sort("hugeInputFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
