package com.rit.palamdrom;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckPermutationisPlamdrom {

	public boolean check(String str) {
		boolean isPalamdrome = false;

		Set<Character> chars = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			Character sub = str.charAt(i);
			if (chars.contains(sub)) {
				chars.remove(sub);
			}
			else
			{
				chars.add(sub);
			}
		}
		if(chars.size()<=1)
		{
			isPalamdrome=true;
		}

		return isPalamdrome;

	}
	
	
}
