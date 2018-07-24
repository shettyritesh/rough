package com.rit.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public List<String> getPermutations(String original)
	{
		
		List<String> resultlist= new ArrayList<String>();
		
		permute("", original, resultlist);
		return resultlist;
		
	}
	
	
	private void permute(String prefix,String suffix,List<String> result)
	{
		if (suffix.length()==0)
		{
			result.add(prefix);
			return;
		}
		for(int i=0;i<suffix.length();i++)
		{
			String newsuffix=suffix.substring(0, i)+suffix.substring(i+1);
			//System.out.println("New Suffic="+newsuffix);
			
			String newprefix=prefix+suffix.charAt(i);
			//System.out.println("New Prefix="+newprefix);
			permute(newprefix, newsuffix,result);
		}
	}

}
