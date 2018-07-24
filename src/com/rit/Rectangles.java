package com.rit;
import java.util.*;

class Point {
	int x;
	int y;

	public Point(int xcord, int ycord) {
		x = xcord;
		y = ycord;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

class Rectangle {
	public Rectangle() {

	}

	public void setTopLeft(Point point) {
		topleft = point;
	}

	public void setTopRight(Point point) {
		topright = point;
	}

	public void setbottomLeft(Point point) {
		bottomleft = point;
	}

	public void setBottomRight(Point point) {
		bottomright = point;
	}

	Point topleft;
	Point topright;
	Point bottomleft;
	Point bottomright;

}

public class Rectangles {
	
	public List<Rectangle> getRectangleCount(int [][]arr)
	{
		


		// Stack<Point> stack= new Stack<Point>();
		List<Rectangle> listOfRectangles = new ArrayList<Rectangle>();

		Rectangles rectang= new Rectangles();
		for (int k = 0; k < arr.length; k++) {

			for (int m = 0; m < arr[0].length; m++) {
				if (arr[k][m] == 1) {
					Rectangle rect=rectang.getRectangle(new Point(k,m),arr);
					if (rect!=null){
						listOfRectangles.add(rect);
					}
				}
			}
		}

		// Rectangle testrect= new Rectangle();
		//
		// testrect.setTopLeft(new Point(0,0));
		// testrect.setTopRight(new Point(0,3));
		// testrect.setbottomLeft(new Point(3,0));
		// testrect.setBottomRight(new Point(3,3));
		// listOfRectangles.add(testrect);
		//
		// testrect= new Rectangle();
		// testrect.setTopLeft(new Point(4,4));
		// testrect.setTopRight(new Point(4,8));
		// testrect.setbottomLeft(new Point(8,4));
		// testrect.setBottomRight(new Point(8,8));
		// listOfRectangles.add(testrect);
		int i = 1;
		for (Rectangle rect : listOfRectangles) {
			System.out.println(i + "):");
			System.out.println(rect.topleft.getX() + "," + rect.topleft.getY() + "    " + rect.topright.getX() + ","
					+ rect.topright.getY());
			System.out.println(rect.bottomleft.getX() + "," + rect.bottomleft.getY() + "    " + rect.bottomright.getX()
					+ "," + rect.bottomright.getY());
			i++;

		}
		return listOfRectangles;

	}

	
	public Rectangle getRectangle(Point point, int[][] arr)
	{
		Rectangle rect= new Rectangle();
		rect.setTopLeft(point);
		Point bottomLeft= null;
		for (int k = point.getX(); k < arr.length; k++) {


			if (arr[k][point.getY()] != 1) {
				bottomLeft=new Point(k-1,point.getY());
				break;

			}			
		}
		
		rect.setbottomLeft(bottomLeft);

		
		
		Point bottomRight= null;
		for (int k = point.getY(); k < arr[0].length; k++) {


			if (arr[point.getX()][k] != 1) {
				bottomRight=new Point(bottomLeft.getX(),k-1);
				break;

			}			
		}
		
		rect.setBottomRight(bottomRight);
		
		Point topright= null;
		for (int k = point.getY(); k < arr[0].length; k++) {


			if (arr[point.getX()][k] != 1) {
				if(bottomLeft.getX()-point.getX()==(k-1)){
					topright=new Point(point.getX(),k-1);
				}
				else
				{
					return null;
				}
				break;

			}			
		}
		
		rect.setTopRight(topright);
	
		
		return rect;
	}
}