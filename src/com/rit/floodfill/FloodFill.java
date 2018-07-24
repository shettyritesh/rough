package com.rit.floodfill;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class FloodFill {
	private char[][] bitmap;

	public FloodFill(char[][] thatBitmap) {
		bitmap=thatBitmap;
	}

	public void floodFill(int x,int y,char fillColor) throws InvalidParameterException{
		
		if(x>bitmap.length){
			throw new InvalidParameterException("X is more than length");
		}
		if(y>bitmap[0].length){
			throw new InvalidParameterException("Y is more than length");
		}
		
		if(fillColor=='_' &&  bitmap[x][y]=='_'){
			return;
		}
		if(fillColor=='#' &&  bitmap[x][y]=='#'){
			return;
		}		
		Stack<Coordinate> stack= new Stack<Coordinate>();
		Coordinate floodfillFirstCell= new Coordinate(x, y);
		stack.push(floodfillFirstCell);
		Map<Coordinate, Boolean> processedMap= new HashMap<Coordinate, Boolean>(); 
		fill(stack, fillColor, processedMap);
		
		
	}
	
	public void fill(Stack<Coordinate> stack, char color, Map<Coordinate, Boolean> processedMap){
		char targetComparisonColor='_';
		char targetConversionColor='#';
		if (color=='_'){
			targetComparisonColor='#';
			targetConversionColor='_';
		}
		while(stack.size()>0){
			Coordinate cordinate= stack.pop();
			//Fill the color
			if(bitmap[cordinate.getX()][cordinate.getY()]==targetComparisonColor)
			{
				bitmap[cordinate.getX()][cordinate.getY()]=targetConversionColor;
				processedMap.put(cordinate, true);
			}
			
			//Check for contrast and push bottom cell for further processing
			if(cordinate.getX()+1<bitmap.length 
					&& bitmap[cordinate.getX()+1][cordinate.getY()]==targetComparisonColor){
				//processedMap.get()
				Coordinate bottomCoordinate=new Coordinate(cordinate.getX()+1,cordinate.getY());
				if(processedMap.get(bottomCoordinate)==null){
					stack.push(bottomCoordinate);
				}
			}
			//Check for contrast and push right cell for further processing			
			if(cordinate.getY()+1<bitmap[0].length 
					&& bitmap[cordinate.getX()][cordinate.getY()+1]==targetComparisonColor){
				Coordinate rightcoordinate= new Coordinate(cordinate.getX(),cordinate.getY()+1);
				if(processedMap.get(rightcoordinate)==null){
					stack.push(rightcoordinate);	
				}
				
			}
			//Check for contrast and push left cell for further processing			
			if(cordinate.getX()-1>=0 
					&& bitmap[cordinate.getX()-1][cordinate.getY()]==targetComparisonColor){
				Coordinate topcordinate= new Coordinate(cordinate.getX()-1,cordinate.getY());
				if(processedMap.get(topcordinate)==null){
					stack.push(topcordinate);
				}
			}
			//Check for contrast and push left cell for further processing			
			if(cordinate.getY()-1>=0 
					&& bitmap[cordinate.getX()][cordinate.getY()-1]==targetComparisonColor){
				Coordinate leftcordinate= new Coordinate(cordinate.getX(),cordinate.getY()-1);
				if(processedMap.get(leftcordinate)==null){
					stack.push(leftcordinate);
				}
			}

			//stack.push(new Coordinate(x+1, y));
		}
	}
	
	public void printBitMap()
	{
		for(int i=0;i<bitmap.length;i++){
			
			for(int j=0;j<bitmap[0].length;j++){
				System.out.print(bitmap[i][j]);
			}
			System.out.println("");
		}
	}
}

 class Coordinate{
	 private int x;
	 private int y;

	 public Coordinate(int xaxis,int yaxis){
		 x=xaxis;
		 y=yaxis;
	 }
	 public int getX(){
		 return x;
	 }
	 public int getY(){
		 return y;
	 }
	 
	@Override
	public int hashCode() {
		
		return Objects.hash(x,y);
	}
	 
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Coordinate){
			Coordinate b= (Coordinate)obj;
			if(x==b.getX() && y==b.getY()){
				return true;
			}
		}
		return false;
	}
 }
