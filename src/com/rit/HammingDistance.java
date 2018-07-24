package com.rit;

public class HammingDistance{
	public int hammingcount(int x , int y)
	{
		int hammingcount=0;
		int m= x^y;
		hammingcount=Integer.bitCount(m);
//		while(m>0)
//		{
//			m&=m-1;
//			hammingcount++;
//		}
		
		return hammingcount;
	}
}


