package com.rit.rotatedarray;

public class RotatedArrayUtil {
	public int getStartIndex(int[] arr, int number) {

		int index = getIndex(arr, 0, arr.length - 1, number);
		return index;
	}

	private int getIndex(int[] arr, int start, int end, int number) {
		if (end - start > 1) {

			int pivot = start + (end - start) / 2;
			boolean isFirst = false;
			if (arr[start] < arr[pivot]) {
				if ((arr[start] <= number) && (number <= arr[pivot])) {
					isFirst = true;
				} else {
					isFirst = false;
				}
			}

			else {
				if ((arr[pivot + 1] <= number) && (number <= arr[end])) {
					isFirst = false;
				} else {
					isFirst = true;
				}

			}
			if (isFirst) {
				return getIndex(arr, start, pivot, number);
			} else {
				return getIndex(arr, pivot + 1, end, number);
			}

		}
		int ret=(arr[start] == number ? start : (arr[end]==number?end:-1));
		return ret;
		

	}
}
