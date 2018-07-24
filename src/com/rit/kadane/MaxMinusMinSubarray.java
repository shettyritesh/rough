package com.rit.kadane;

public class MaxMinusMinSubarray {

	int getCountOfMaxMinusMinSubarray(int[] arr,int k)
	{
		if (arr==null){
			throw new RuntimeException("Array cannot be null");
		}
		if(arr.length==1)
		{
			throw new RuntimeException("Atleast 2 elements needed");
		}
		
		if(arr.length==2)
		{
			return 1;
		}
		int count=0;
		int max=k;
		int i=0;
		int j=0;
		while(i<arr.length&&arr[i]<=max&&arr[j]<=max){
			if(arr[i]+arr[j]<k){
				count++;
				System.out.println("i = "+arr[i]+" j = "+arr[j]);
				j++;
			}
			else
			{
				i++;
				j=i;
			}

		}
		
		return count;
		
	}
}
