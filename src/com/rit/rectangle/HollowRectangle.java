package com.rit.rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

public class HollowRectangle {
	private int[][] arr;
	private Set<Pair> visited= new HashSet<>();
	private Map<Integer, List<Pair>> mapOfRect= new HashMap(); 
	public HollowRectangle(int[][] matrix){
		arr=matrix;
		process();
	}
	public void printRectangles(){
		Set<Integer> keys= mapOfRect.keySet();
		for(Integer key:keys){
			System.out.println("Rectangle number "+key);
			List<Pair> list=mapOfRect.get(key);
			for(Pair pair:list){
				System.out.print(pair.getRow()+","+pair.getCol()+" ");
			}
			System.out.println();
			
		}
	}
	private void process(){
		int rectanglecount=0;
		for(int row=0;row<arr.length;row++){
			
			for(int col=0;col<arr[0].length;col++){
				if(arr[row][col]==1){
					Pair pair = new Pair(row,col);
					if(!visited.contains(pair)){
						rectanglecount++;
						findRectangle(pair,rectanglecount);
					}
				}
			}
		}
	}
	
	private void findRectangle(Pair pair,int rectanglecount){
		int row=pair.getRow();
		int col= pair.getCol();
		while(arr[row][col]==1){

			if(arr[row][col]==1){
				visited.add(new Pair(row,col));
				col++;				
			}
			if(col>arr[0].length-1){
				break;
			}			
		}
		final int maxcol=col-1;

		
		row=pair.getRow();
		col= pair.getCol();
		
		while(arr[row][col]==1){
			if(arr[row][col]==1){
				visited.add(new Pair(row,col));
				row++;
			}
			if(row>arr.length-1){
				break;
			}
			
		}
		final int maxrow=row-1;

		col=maxcol;
		row=pair.getRow();
		while(arr[row][col]==1){

			if(arr[row][col]==1){
				visited.add(new Pair(row,col));
				row++;				
			}
			if(row>maxrow){
				break;
			}			
		}
		
		col=maxcol;
		row=maxrow;
		while(arr[row][col]==1){

			if(arr[row][col]==1){
				visited.add(new Pair(row,col));
				col--;				
			}
			if(col<0){
				break;
			}			
		}

		
		List<Pair> list= new ArrayList<Pair>();
		list.add(pair);
		list.add(new Pair(maxrow,maxcol));
		mapOfRect.put(rectanglecount, list);
		

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
