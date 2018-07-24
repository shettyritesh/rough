package com.rit.kadane;

import java.util.ArrayList;
import java.util.List;

public class SmallestPairInTwoSortedArray {

	public List<String> getSmallestPairs(int[] arr1, int[]arr2, int K)
	{
		List<String> list= new ArrayList<String>();
		
		int i1=0,i2=0,i=0;
		int j1=0,j2=0,j=0;
		
		while(list.size()<K)
		{
			list.add(arr1[i]+" "+arr2[j]);
			if((arr1[i1+1]+arr2[j1]) <  (arr1[i2]+arr2[j2+1])  ){
				i1++;
				i=i1;
				j=j1;
				if(i1>=arr1.length)
				{
					i1=0;
					j1++;
				}
			}
			else{
				j2++;
				i=i2;
				j=j2;				
				if(j2>=arr2.length)
				{
					j2=0;
					i2++;
				}

			}
		}
		
		return list;
	}
}
