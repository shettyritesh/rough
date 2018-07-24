package com.rit.kadane;

public class Kadane {

	public int getMaximumSubarray(int[]arr)
	{
		if(arr==null)
		{
			throw new RuntimeException("Invalid argument");
		}
		
		if(arr.length==1)
		{
			return arr[0];
		}
		
		int max_current= arr[0];
		int max_global= arr[0];
		for(int i=0;i<arr.length;i++)
		{
			max_current=Math.max(arr[i],max_current+arr[i]);
			max_global=Math.max(max_global, max_current);
		
		}	
		
		return max_global;
	}
	

}
