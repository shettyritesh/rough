package com.rit.binarysearcharray;

public class SearchInSortedMatrix
{//1

	public static void main(String[] args)
	{//2
		int[][] mat =           { {10, 20, 30, 40},
                		      {15, 25, 35, 45},
		                      {27, 29, 37, 48},
                		      {32, 33, 39, 50}};
		SearchInSortedMatrix searchutil= new SearchInSortedMatrix();
		int number = 29;
		String position="";
        System.out.println("Search 29");

		position=searchutil.search(mat,number);
		System.out.println(position);
		number=36;
        System.out.println("Search 36");		
		position=searchutil.search(mat,number);
		System.out.println(position);

		number=101;
        System.out.println("Search 101");		
		position=searchutil.search(mat,number);
		System.out.println(position);
		number=5;
        System.out.println("Search 5");		
		position=searchutil.search(mat,number);
		System.out.println(position);
		
		number=10;
        System.out.println("Search 10");		
		position=searchutil.search(mat,number);
		System.out.println(position);		
	}//2
	
	public String search(int[][] arr, int number)
	{//3
		try{
		int x=findRow(arr,0,arr.length,number);	
		int y=	findNumber(arr,x,0,arr[0].length,number);
		return x+","+y;
		}catch(RuntimeException exp)
		{
			return exp.getMessage();
		}
		
		
		
	}//3

	public int findNumber(int[][] arr,int x,int start, int end, int number)
	{	
		
		if(start>end)
		{
			throw new RuntimeException("Not Found");
		}
		
		int pivot=0;
		if(start==end){
			pivot=0;
		}
		else{
			pivot=(end-start)/2;
		}

		Integer result=0;
		if(arr[x][start+pivot]==number)
		{
			result=pivot+start;
		}
		else if(number<arr[x][pivot+start])
		{
			result= findNumber(arr,x,start,start+pivot-1,number);
		}
		else if(number>arr[x][pivot+start])
		{
			result= findNumber(arr,x,start+pivot+1,end,number);		
		}
		if (result==null)
		{
			throw new RuntimeException("Not Found");
		}
		return result;
	}

	public int findRow(int[][] arr,int start, int end, int number)
	{
		Integer pivot=null;
		int minY=0;
		int maxY=arr[0].length-1;
		Integer result=null;
		
		if(start>end)
		{
			throw new RuntimeException("Number Not Found");
		}

		if(start==end){
			pivot=start;

			if((number <arr[start+pivot][minY]) || (number>arr[start+pivot][maxY]) )
			{
				throw new RuntimeException("Number Not Found");
			}
		}
		else
		{
			pivot=(end-start)/2;
		}
		
		if(arr[start+pivot][minY]<=number && number<=arr[start+pivot][maxY])
		{	if((start+pivot>=0)|| (start+pivot<=maxY)){
				result=start+pivot;
			}
		}
		else if(number<arr[start+pivot][minY])
		{	if((start+pivot-1)>=0){
				result= findRow(arr,start,start+pivot-1,number);
			}
		}
		else if(number>arr[start+pivot][maxY])
		{
			if((start+pivot+1)<=maxY){
				result= findRow(arr,start+pivot+1,end,number);		
			}

		}
		if (result==null)
		{
			throw new RuntimeException("Number Not Found");
		}
		return result;
	}

}//1