package com.rit.totalnegative;

public class FindTotalNegativeNumbers {
	
	int gettotalNegativeNumbers(int[][]arr)
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			int current=0;
			for(int j=0;j<arr[0].length;j++)
			{
				if (arr[i][j]<0)
				{
					current++;
				}
				else
				{
					sum=sum+current;
					break;
					
				}
			}
		}
		return sum;
	}

}
