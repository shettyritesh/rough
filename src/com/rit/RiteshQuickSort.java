package com.rit;

import java.util.Arrays;

public class RiteshQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        RiteshQuickSort qs= new RiteshQuickSort();
        System.out.format("Before %s\n",Arrays.toString(input));
        qs.quicksort(input, 0, input.length-1);
        System.out.format("After %s\n",Arrays.toString(input));

	}
	void exchange(int[] arr, int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	void quicksort(int[] arr , int start, int end)
	{
		int pivot =arr[start+(end-start)/2];
		int i=start;
		int j=end;
		while(i<=j)
		{
			while(arr[i]<pivot)
			{
				i++;
			}
			while(arr[j]>pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				exchange(arr,i,j);
				i++;
				j--;
			}			
		}
		if(start<j)
		{
			quicksort(arr,start,j);
		}
		if(end>i)
		{
			quicksort(arr,i,end);
		}
	}


}
