package com.rit.binarysearcharray;

import java.util.Collections;

public class BinarySearchArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {104,105,108,109,110,111,112,114,115,117,119,120,121};
		BinarySearchArray binasearch = new BinarySearchArray();
		binasearch.search(arr, 0, arr.length-1,117);
		
		

	}
	
	boolean search(int[]arr, int start, int end , int number )
	{
		boolean found= false;
		
		if(start==end)
		{
			System.out.println("Answer is"+arr[start]);
			return true;
		}
		if(end>start)
		{
			int pivot=(end-start)/2;
			System.out.println("pivot is "+(start+pivot));
			
			if(number<=arr[start+pivot])
			{
				search(arr,start,start+pivot,number);
			}
			else if(number>arr[start+pivot])
			{
				
				search(arr,start+pivot+1,end,number);
			}
		}
		
		
		
		
		return found;
	}

}
