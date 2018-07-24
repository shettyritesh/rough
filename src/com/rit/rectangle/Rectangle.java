package com.rit.rectangle;
import java.lang.Math;

public class Rectangle {
	private int[][] arr;

	public Rectangle(int[][] iarr) {
		arr = iarr;
	}

	public int findMaxRectangle() {
		int max = 0;
		int currmax = 0;
		int[] register = new int[arr[0].length];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == 1) {
					register[col] = register[col] + 1;
				} else {
					register[col] = 0;
				}
			}
			currmax = getMaxRect(register);
			max = Math.max(max, currmax);
		}

		return max;

	}
	private int getMaxRect(int[] register) {
		int currentSize = 0;
		int max = 0;
		int currmax = 0;
		for (int i = 0; i < register.length; i++) {
			if (currentSize == register[i]) {
				continue;
			}
			currmax = 0;
			for (int j = i; j < register.length; j++) {
				if (i == j) {
					currentSize = register[j];
				}
				if (register[j] >= currentSize) {
					currmax = currmax + currentSize;
					max = Math.max(currmax, max);
				}
				else if (register[j]!=0){
					int units= currmax/currentSize;
					currentSize=register[j];
					currmax=currentSize+units*currentSize;
					max = Math.max(currmax, max);
				}
				
			}
		}
		return max;
	}

//	private int getMaxRect(int[] register) {
//		int currentSize = 0;
//		int max = 0;
//		int currmax = 0;
//		for (int i = 0; i < register.length; i++) {
//			if (currentSize == register[i]) {
//				continue;
//			}
//			currmax = 0;
//			for (int j = i; j < register.length; j++) {
//				if (i == j) {
//					currentSize = register[j];
//				}
//				if (register[j] >= currentSize) {
//					currmax = currmax + currentSize;
//					max = Math.max(currmax, max);
//				}
//			}
//		}
//		return max;
//	}
}