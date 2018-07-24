package com.rit.top3;

import java.util.Arrays;

public class Solution {
	public static void main(String args[])
	{
		Solution s= new Solution();
		int[] arr={1,1,1,0};
		System.out.println(s.threeSumClosest(arr, 100));
	}
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer minimumdiff=null;
        for(int i=0; i<nums.length;i++)
        {
            
            int start=i+1;
            int end=nums.length-1;
            while((end-start)>=1)
            {
            	System.out.println("I is "+i);
            	System.out.println("start is "+start);
            	System.out.println("end is "+end);
                int sum=nums[i]+nums[start]+nums[end];
                System.out.println("Sum is"+sum);
                if (sum<target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
                
                if(minimumdiff==null)
                {
                    minimumdiff=sum;
                }
                else if(Math.abs(target-sum)<Math.abs(target-minimumdiff))
                {
                    
                    minimumdiff=sum;
                }
                
            }
        }
        
        return minimumdiff;
    }
}	