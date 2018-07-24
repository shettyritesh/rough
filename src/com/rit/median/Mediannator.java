package com.rit.median;

class Mediannator{


//{3,6,15,25} ,{1,4,9,23}
//{3,6,15,25} ,{1,4,9,23 ,24}
//{} ,{1,4,9,23}
//{3,6,15,25} ,{}
//{} {}

public double getMedian(int[] arr1, int[] arr2){

	if(arr1.length==0 && arr2.length==0){
		return 0;
	}

	return findMedian(arr1,arr2,0,arr1.length);
	
}


private double findMedian(int[] arr1, int[]arr2, int start,int end){
	int pivt1=start+ (end-start)/2;
	//pivt1=2
	int pivt2=(arr1.length+arr2.length+1)/2-pivt1;
	//pivt2=2
	int arr1FHMax=getValue(arr1,pivt1-1);
	//arr1FHMax=6
	int arr2FHMax=getValue(arr2,pivt2-1);
	//arr2FHMax=4
	int arr1SHMin=getValue(arr1,pivt1);
	//arr1SHMin =15
	int arr2SHMin=getValue(arr2,pivt2);
	//arr2SHMin=9
	
	if(arr1FHMax<=arr2SHMin  && arr2FHMax<=arr1SHMin){
		if((arr1.length+arr2.length)%2>0){
			return Math.max(arr1FHMax,arr2FHMax);
		}
		else{
			return (Math.max(arr1FHMax,arr2FHMax)  + Math.min(arr1SHMin,arr2SHMin))/2.0;
		}
	
	}
	
	if(arr1FHMax>arr2SHMin){
		end=pivt1;
	}
	if(arr2FHMax>arr1SHMin){
		start=pivt1+1;
	}
	return findMedian(arr1,arr2,start,end);

}

private int getValue(int[] arr,int index){

	 return (index<0?Integer.MIN_VALUE:(index>=arr.length?Integer.MAX_VALUE:arr[index]));
}



}