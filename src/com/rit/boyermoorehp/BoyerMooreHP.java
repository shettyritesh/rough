package com.rit.boyermoorehp;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreHP {

	public int search(String s, String pattern) {
		Map<Character, Integer> table = calculateTable(pattern);

		for (int i = 0; i < s.length(); i++) {
			for (int j = pattern.length() - 1; j >= 0; j--) {
				if (s.charAt(i + j) != pattern.charAt(j)) {
					Integer mismatch = table.get(s.charAt(i + j));
					if (mismatch == null) {
						mismatch = pattern.length();
					}
					i = i + mismatch - 1;
					break;
				}
				if (j == 0) {
					System.out.println(i + " " + (i + pattern.length()));
					System.out.println(s.substring(i, i + pattern.length()));
					return i;
				}
			}
		}
		return -1;
	}

	private Map<Character, Integer> calculateTable(String pattern) {
		Map<Character, Integer> table = new HashMap<Character, Integer>();

		for (int i = 0; i < pattern.length() - 1; i++) {
			table.put(pattern.charAt(i), pattern.length() - 1 - i);
		}
		// table.entrySet().forEach(x->System.out.println(x.getKey()+"-"+x.getValue()));
		return table;
	}

}
