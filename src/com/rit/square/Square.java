package com.rit.square;

class Square {
	private int[][] arr;

	public Square(int[][] iarr) {
		arr = iarr;
	}

	public void findMaxSquare() {
		int max = 0;
		int[][] result = new int[arr.length][arr[0].length];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == 1) {
					int top = 0, topleft = 0, left = 0;
					if ((row - 1) >= 0 && (col - 1) >= 0) {
						topleft = result[row - 1][col - 1];
					}
					if ((row - 1) >= 0) {
						top = result[row - 1][col];
					}
					if ((col - 1) >= 0) {
						left = result[row][col - 1];
					}
					if (row == 5 && col == 1) {
						System.out.println("This line has problem");
					}
					result[row][col] = min(top, left, topleft) + 1;
					if (max < result[row][col]) {
						max = result[row][col];
					}

				}

			}

		}
		System.out.println("Max Square is of size " + max * max);
		System.out.println("Before*****************");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

		System.out.println("After*****************");
		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[0].length; col++) {
				System.out.print(result[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static int min(int A, int B, int C) {
		return Math.min(Math.min(A, B), C);

	}
}
