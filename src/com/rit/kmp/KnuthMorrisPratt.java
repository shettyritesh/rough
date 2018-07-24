package com.rit.kmp;

public class KnuthMorrisPratt {
	public int brutForceSearch(String text, String pattern) {
		int foundIndex = -1;
		
		for(int textIndex=0;textIndex<text.length();textIndex++)
		{
			for(int patternIndex=0;patternIndex<pattern.length();patternIndex++)
			{
				if(pattern.charAt(patternIndex)!=text.charAt(textIndex))
				{
					break;
				}
				else
				{
					textIndex++;

					if(patternIndex==pattern.length()-1)
					{
						return textIndex-pattern.length();
					}
				}
			}
			
		}
		return foundIndex;
	}
	
	public int search(String text, String pattern) {
		int foundIndex = -1;
		
		for(int textIndex=0;textIndex<text.length();textIndex++)
		{
			for(int patternIndex=0;patternIndex<pattern.length();patternIndex++)
			{
				if(pattern.charAt(patternIndex)!=text.charAt(textIndex))
				{
					if(patternIndex!=0){
						int sufficlength=getPrefixSuffixMatch(pattern.substring(0, patternIndex));
						if(sufficlength!=0){
							textIndex=textIndex+pattern.length()-1-sufficlength;
							patternIndex=patternIndex+sufficlength;
						}
	
					}
					break;
					
				}
				else
				{
					textIndex++;

					if(patternIndex==pattern.length()-1)
					{
						return textIndex-pattern.length();
					}
				}
			}
			
		}
		return foundIndex;
	}
	
	public int getPrefixSuffixMatch(String matchedstring)
	{
		int j=matchedstring.length()-1;
		String bestmacth=null;
		for(int i=0;i<matchedstring.length();i++)
		{
			if (matchedstring.substring(0, i)==matchedstring.substring(j-i))
			{
				bestmacth=matchedstring.substring(0, i);
			}
			if (i>=(j-i))
			{
				break;
			}
		}
		int match=(bestmacth!=null?bestmacth.length():0);
		
		return match;
		
	}

}
