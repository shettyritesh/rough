package com.rit.treasurehunt;

import java.util.*;

class Point {
	int x;
	int y;

	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}

	public boolean equals(Object obj) {
		Boolean isequal = false;

		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (p.x == x && p.y == y) {
				return true;
			}
		}
		return isequal;
	}

	public int hashCode() {

		return Objects.hash(x, y);
	}

}

public class TreasureHunt {

	public void getDirections(String[][] arr, Point point) {
		if (point == null) {
			point = new Point(0, 0);
		}

		ArrayList<Point> list = new ArrayList<Point>();
		list.add(point);

		Stack<ArrayList<Point>> stack = new Stack<ArrayList<Point>>();
		stack.push(list);
		ArrayList<Point> prev = null;
		while (!stack.isEmpty()) {

			ArrayList<Point> tmplist = stack.pop();
			Point tmppoint = getLast(tmplist);
			prev = processCell(arr, stack, prev, tmplist, tmppoint, tmppoint.x, tmppoint.y - 1);
			prev = processCell(arr, stack, prev, tmplist, tmppoint, tmppoint.x, tmppoint.y + 1);
			prev = processCell(arr, stack, prev, tmplist, tmppoint, tmppoint.x - 1, tmppoint.y);
			prev = processCell(arr, stack, prev, tmplist, tmppoint, tmppoint.x + 1, tmppoint.y);
		}

		if (prev != null) {
			for (Point p : prev) {

				System.out.println(p.x + " " + p.y);
			}
		}

	}// get directions

	private ArrayList<Point> processCell(String[][] arr, Stack<ArrayList<Point>> stack, ArrayList<Point> prev,
			ArrayList<Point> tmplist, Point tmppoint, int x, int y) {
		Point newpoint = new Point(x, y);
		if (y >= 0 && y <= (arr[0].length - 1) && x >= 0 && x <= (arr.length - 1) && !"X".equals(arr[x][y])
				&& !tmplist.contains(newpoint)) {

			ArrayList<Point> tmplist1 = cloneList(tmplist);
			tmplist1.add(newpoint);
			if (isTreaurefound(arr, x, y)) {
				prev = getBestPath(prev, tmplist1);
			} else {
				stack.push(tmplist1);
			}
		}
		return prev;
	}

	private ArrayList<Point> cloneList(ArrayList<Point> tmplist) {
		return (ArrayList<Point>) tmplist.clone();
	}

	private Point getLast(ArrayList<Point> tmplist) {
		return tmplist.get(tmplist.size() - 1);
	}

	private Boolean isTreaurefound(String[][] arr, int x, int y) {
		if ("$".equals(arr[x][y])) {
			return true;
		}
		return false;
	}

	private ArrayList<Point> getBestPath(ArrayList<Point> prev, ArrayList<Point> curr) {
		if ((prev == null) || prev.size() > curr.size()) {
			return curr;
		}

		else {
			return prev;
		}

	}
}// class TReasureHunt

/*
 * arr={{0,X,0,0}, {0,0,0,0}, {0,0,X,$}, {0,X,0,0}};
 * 
 **/