package com.rit;

import java.util.Scanner;

public class Spiral {
	int horiT, horiB, vertL, vertR;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int matrixx = scanner.nextInt();
		int matrixy = scanner.nextInt();
		int[][] numbers = new int[matrixx][matrixy];
		for (int i = 0; i < matrixx; i++) {
			for (int j = 0; j < matrixy; j++) {
				numbers[i][j] = scanner.nextInt();
			}
		}
		Spiral spiral = new Spiral();
		spiral.horiT = 1;
		spiral.horiB = numbers.length;
		spiral.vertL = 1;
		spiral.vertR = numbers[0].length;
		int count = 0;
		while ((spiral.horiT <= spiral.horiB) && (spiral.vertL <= spiral.vertR)) {
			count++;
			int directn = (count % 4 == 0 ? 4 : count % 4);
			spiral.printSpiral(numbers, directn);
		}
	}

	void printSpiral(int[][] arr, int direction) {
		if (direction == 1) {
			for (int i = vertL - 1; i < vertR; i++) {
				System.out.println(arr[horiT - 1][i]);
			}
			this.horiT++;
		}
		if (direction == 2) {
			for (int i = horiT - 1; i <= horiB - 1; i++) {
				System.out.println(arr[i][vertR - 1]);
			}
			this.vertR--;
		}

		if (direction == 3) {
			for (int i = vertR - 1; i >= vertL - 1; i--) {
				System.out.println(arr[horiB - 1][i]);
			}
			this.horiB--;
		}

		if (direction == 4) {
			for (int i = horiB - 1; i >= horiT - 1; i--) {
				System.out.println(arr[i][vertL - 1]);
			}
			this.vertL++;
		}
	}
}
