package com.rit.permutation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestPermutations {

	@Test
	public void testGetPermutations() {
		//Assert.assertTrue(condition);
		Permutations perm= new Permutations();
		List<String> lst=perm.getPermutations("ABC");
		System.out.println(lst.size());
		List<String> expected= new ArrayList<>();
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CAB");
		expected.add("CBA");

		
		Assert.assertTrue(lst.equals(expected));
		
	}

}
