package com.rit;

import java.util.concurrent.TimeUnit;

public class Rough{
	public static void main(String[] args){
		int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};

		int rowmin=0;
		int rowmax=arr.length;
		int rowcursor=rowmin;
		int rowincrement=1;

		int colmin=0;
		int colmax=arr[0].length;
		int colcursor=colmax-1;
		int colincrement=-1;
		
		while(rowmin<rowmax && colmin<colmax) {
			try {
				TimeUnit.MICROSECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printRow(arr,rowcursor,colmin,colmax,rowincrement);

			if(rowcursor==rowmax) {
				//rowincrement=-1;
				rowmin++;
				System.out.println("Switch");
			}
			if(rowcursor==rowmin) {
				//rowincrement=1;
				rowmax-=1;
				System.out.println("Switch");
			}
			
			
			rowcursor+=(rowincrement*Math.abs(rowmax-rowmin));
			printCol(arr,colcursor,rowmin,rowmax,colincrement);
			rowincrement*=-1;
			

			
			
			if(colcursor==colmax) {
				//rowincrement=-1;
				colmin++;
				System.out.println("Switch");
			}
			if(colcursor==colmin) {
				//rowincrement=1;
				colmax-=1;
				System.out.println("Switch");
			}
			
			
			colcursor+=(colincrement*Math.abs(colmax-colmin));
			colincrement*=-1;
			
		}
		
		

}
	
	private static void printRow(int[][] arr,int row,int colmin,int colmax,int dir){
		System.out.println("Print Row");
		if(dir>0) {
			for(int i=colmin;i<colmax;i++) {
				System.out.println(arr[row][i]);	
			}
		}
		else {
			for(int i=colmax-1;i>=colmin;i--) {
				System.out.println(arr[row][i]);	
			}
			
		}
		
			
		
	}
	
	private static void printCol(int[][] arr,int col,int rowmin,int rowmax,int dir){
		System.out.println("Print Col");
		if(dir>0) {
			for(int i=rowmin;i<rowmax;i++) {
				System.out.println(arr[i][col]);	
			}
		}
		else {
			for(int i=rowmax-1;i>=rowmin;i--) {
				System.out.println(arr[i][col]);	
			}
			
		}
		
			
		
	}	
}
