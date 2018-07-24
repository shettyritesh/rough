package com.rit.median;

import java.util.Arrays;

class MyMedian {

	// diff sizes
	// zero size
	// all integers
	// possible duplicates
	// odd and even
	// should be O(m+n)
	// no extra space complexity

	public double getMedian(int[] first, int[] second) {
		if(first.length==0 && second.length==0) {
			return 0;
		}
		if(first.length==0) {
			return getSingleArrayMedian(second);
			
		}
		if(second.length==0){
			return getSingleArrayMedian(first);
		}
		return getMedian(first, second, 0, first.length);
	}
	private double getSingleArrayMedian(int[] arr) {
		if (arr.length==1) {
			return arr[0];
		}	
		int pivit=(arr.length+1)/2;
		if (arr.length%2>0) {
			return arr[pivit-1];
		}
		return (arr[pivit-1]+ arr[pivit])/2.0;
	}
	private double getMedian(int[] first, int[] second, int start, int end) {

		int pivit1 = start + (end - start) / 2;
		int pivit2 = ((first.length + second.length + 1) / 2) - pivit1;
		int firstarr1maxval = (pivit1 <= 0 ? Integer.MIN_VALUE : first[pivit1 - 1]);
		int firstarr2maxval = getMaxValue(second, pivit2);
		int secondhalfarr1sminval=(pivit1>=first.length?Integer.MAX_VALUE:first[pivit1]);
		int secondhalfarr2sminval = getMinValue(second, pivit2);
		if ((firstarr1maxval <= secondhalfarr2sminval) && (firstarr2maxval <= secondhalfarr1sminval)) {
			if((first.length+second.length)%2>0) {
				return Math.max(firstarr1maxval, firstarr2maxval);
			}
			return (Math.max(firstarr1maxval, firstarr2maxval) + Math.min(secondhalfarr2sminval, secondhalfarr1sminval))/2.0;
		}

		if (firstarr1maxval > secondhalfarr2sminval) {
			end = pivit1;
			return getMedian(first, second, start, end);

		}
		start = pivit1 + 1;
		return getMedian(first, second, start, end);

	}
	private int getMinValue(int[] second, int pivit2) {
		int secondhalfarr2sminval=0;
		if(pivit2>=second.length)
			{secondhalfarr2sminval=Integer.MAX_VALUE;}
		else 
			{
			secondhalfarr2sminval=(pivit2<0?Integer.MIN_VALUE:second[pivit2]);
			}
		return secondhalfarr2sminval;
	}
	private int getMaxValue(int[] second, int pivit2) {
		int firstarr2maxval = 0;
		if(pivit2 <= 0) {
			firstarr2maxval = Integer.MIN_VALUE ;
			}
		else{
			firstarr2maxval=(pivit2-1>=second.length?Integer.MAX_VALUE:second[pivit2 - 1]);
		}
		return firstarr2maxval;
	}

}