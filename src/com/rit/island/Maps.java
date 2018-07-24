package com.rit.island;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Maps {
	private int[][] map;
	private Map<Integer, Set<Pair>> mapOfIslands = new HashMap();
	private Set<Pair> visited = new HashSet();

	public Maps(int[][] arr) {
		map = arr;
		process();
	}

	public void process() {
		int islandCount = 0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if(map[row][col]==1){
					Pair pair = new Pair(row, col);
					if (!visited.contains(pair)) {
						islandCount++;
						findNeighbours(pair, islandCount);
					}
				}

			}
		}

	}

	public void printIslands() {
		Set<Integer> keys = mapOfIslands.keySet();
		for (Integer item : keys) {
			Set<Pair> pairset = mapOfIslands.get(item);
			for (Pair mypair : pairset) {
				System.out.println(item + ":  " + mypair.getRow() + "  " + mypair.getCol());
			}
		}

	}

	private void findNeighbours(Pair pair, Integer islandnumber) {
		if (pair.getRow() < 0 || pair.getRow() > map.length - 1) {
			return;
		}
		if (pair.getCol() < 0 || pair.getCol() > map[0].length - 1) {
			return;
		}
		if (visited.contains(pair)) {
			return;
		}
		if (map[pair.getRow()][pair.getCol()] == 1) {
			visited.add(pair);
			Set<Pair> pairset = mapOfIslands.get(islandnumber);
			if (pairset == null) {
				pairset = new HashSet<Pair>();
			}
			pairset.add(pair);
			mapOfIslands.put(islandnumber, pairset);

			int row = pair.getRow();
			int col = pair.getCol();
			findNeighbours(new Pair(row - 1, col - 1), islandnumber);
			findNeighbours(new Pair(row - 1, col), islandnumber);
			findNeighbours(new Pair(row - 1, col + 1), islandnumber);
			findNeighbours(new Pair(row, col - 1), islandnumber);
			findNeighbours(new Pair(row, col + 1), islandnumber);
			findNeighbours(new Pair(row + 1, col - 1), islandnumber);
			findNeighbours(new Pair(row + 1, col), islandnumber);
			findNeighbours(new Pair(row + 1, col + 1), islandnumber);

		}
	}
}

class Pair {
	private int row;

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	private int col;

	public Pair(int rowthat, int colthat) {
		row = rowthat;
		col = colthat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Pair) {
			Pair objpair = (Pair) obj;
			if (objpair.getRow() == getRow() && objpair.getCol() == getCol()) {
				return true;
			}

		}
		return false;
	}

}
