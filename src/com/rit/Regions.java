package com.rit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

class Pointer {
	int x;
	int y;

	public Pointer(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}

	public boolean equals(Object obj) {
		boolean isequal = false;

		if (obj instanceof Pointer) {
			Pointer comparee = (Pointer) obj;
			if (comparee.x == x && comparee.y == y) {
				isequal = true;
			}
		}
		return isequal;

	}

	public int hashCode() {
		int compareResult = 0;

		return Objects.hash(x, y);
	}
}

public class Regions {
	Map<String, Set<Pointer>> islands = new <String, Set<Pointer>>HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int maxX = scan.nextInt();
		int maxY = scan.nextInt();
		int[][] arr = new int[maxX][maxY];
		Regions region = new Regions();
		for (int x = 0; x < maxX; x++) {
			for (int y = 0; y < maxY; y++) {
				arr[x][y] = scan.nextInt();
			}
		}

		for (int x = 0; x < maxX; x++) {
			for (int y = 0; y < maxY; y++) {
				if (arr[x][y] == 1) {
					region.process(arr, new Pointer(x, y));
				}
			}
		}

		Set<String> keys = region.islands.keySet();
		for (String key : keys) {
			Set<Pointer> previouspoints = region.islands.get(key);
			for (Pointer p : previouspoints) {

				System.out.println(p.x + " " + p.y);
			}

		}
	}

	public void process(int[][] arr, Pointer newpoint) {
		if (arr[newpoint.x][newpoint.y] == 1) {
			Set<Pointer> pointsets = null;
			int x = newpoint.x;
			int y = newpoint.y;
			Set<String> keys = islands.keySet();
			Stack<Pointer> stack = new <Pointer>Stack();

			for (String key : keys) {
				Set<Pointer> previouspoints = islands.get(key);
				if (previouspoints.contains(newpoint)) {
					return;
				}

			}

			String uuid = UUID.randomUUID().toString();
			pointsets = new <Pointer>HashSet();
			islands.put(uuid, pointsets);

			while (arr[x][y] == 1)  {
				while ((arr[x][y] == 1) && (y<arr[0].length)) {
					stack.push(newpoint);
					y++;
				}

				if (!stack.isEmpty())  {
					Pointer point = stack.pop();
					pointsets.add(point);
					if ((x<arr.length) &&(arr[point.x + 1][point.y] == 1)) {
						x = x + 1;
					}
				}
			}

		}
	}

}
