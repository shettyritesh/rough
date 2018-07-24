package com.rit.synonym;
//Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

//[(good, high), (rating, reviews), (restaurant, bistro)]
//("high restaurant rating", "good bistro reviews") -> true
//("cafe rating", "restaurant reviews") -> false

//Req take any datastructure for the pair
//Expect 2 strings and give the response as boolean
//All ascii code and all lowercase
//All space seperated
//ignore punctuations
//Bidirectional map 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestSynonym {

	@Test
	public void testSynonym() {
		Synonym util = new Synonym();
		boolean ans = util.test("high restaurant rating", "good bistro reviews");

		// TODO testcase
	}

}

// (good, high)
// (good, great)

class Synonym {
	// precompute the final synonym
	Map<String, String> map = new HashMap<String, String>();

	// Main dict as input
	Map<String, List<String>> allsynonoym = new HashMap<String, List<String>>();

	// init
	{

		// TODO prepopulate maps for synonym using the list above
		Set<String> list = allsynonoym.keySet();
		for (String key : list) {
			List<String> allsyn = allsynonoym.get(key);
			Collections.sort(allsyn);
			String keyforuse = allsyn.get(0);
			map.put(key, keyforuse);

		}
	}

	public boolean test(String first, String sec) {
		String[] arr1 = first.split(" ");
		String tmpfirst = first;
		String tmpsec = sec;
		List<String> final1 = new ArrayList<String>();
		// TODO move to function
		for (String word : arr1) {
			String synonym = map.get(word);
			if (synonym != null) {
				final1.add(synonym);
			} else {
				final1.add(word);
			}
			// tmpfirst=tmpfirst.replace(word,synonym);
		}
		String[] arr2 = sec.split(" ");
		List<String> final2 = new ArrayList<String>();
		for (String word : arr2) {
			String synonym = map.get(word);
			if (synonym != null) {
				final2.add(synonym);
			} else {
				final2.add(word);
			}

			// tmpsec=tmpsec.replace(word,synonym);
		}
		tmpsec = "";
		for (String word : final1) {
			tmpfirst = tmpfirst + " " + word;
		}
		for (String word : final2) {
			tmpsec = tmpsec + " " + word;
		}
		if (tmpsec.equals(tmpfirst)) {
			return true;
		}
		return false;
	}

}
