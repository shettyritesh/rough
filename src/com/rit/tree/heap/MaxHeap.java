package com.rit.tree.heap;


public class MaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap myheap= new Heap();
		myheap.push(100);
		myheap.push(70);
		myheap.push(101);
		myheap.push(1001);
		myheap.push(2);
		System.out.println("Peek "+myheap.peek());
		while(myheap.size()>0)
		{
			System.out.println(myheap.pop());
		}

	}

}

class Heap {
	private Node[] arr;
	private int counter=0;
	int DEFAULT_HEAP_SIZE=16;
	
	public Heap(){
		arr=new Node[DEFAULT_HEAP_SIZE];
	}
	
	public Heap(int heapSize){
		if(heapSize<1)
		{
			throw new RuntimeException("Invalid Size");
		}
		arr=new Node[heapSize];
	}	

	public void push(int newNodeValue) {
		
		Node newNode= new Node(newNodeValue);
		counter++;
		arr[counter]=newNode;
		
		heapifyUp(counter);
	}
	
	private void heapifyUp(int  nodeIndex)
	{
		int parentIndex=0;
		if (nodeIndex>1)
		{
			parentIndex=nodeIndex/2;
			if(arr[parentIndex].value<arr[nodeIndex].value)
			{
				swap(arr,parentIndex,nodeIndex);
				heapifyUp(parentIndex);
			}
		}
		
	}
	
	
	private void heapifyDown(int  nodeIndex)
	{
		if (nodeIndex<counter)
		{
			int biggeNode=max(arr,nodeIndex);
			if(arr[biggeNode].value>arr[nodeIndex].value)
			{
				swap(arr,nodeIndex,biggeNode);
				heapifyDown(biggeNode);
			}
		}
		
	}
	
	public void swap(Node[] arr,int index1,int index2)
	{
		Node tmp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=tmp;
	}

	public Node pop() {
		if (counter==0)
		{
			throw new RuntimeException("No more");
			
			
		}
		Node max= arr[1];
		arr[1]=arr[counter];
		arr[counter]=null;
		counter--;
		System.out.println("Counter is"+counter);

		if(counter>0){
			heapifyDown(1);
		}		
		
		
		return max;
	}

	
	public int size() {

		return counter;
	}
	
	public Node peek() {
		if (counter==0)
		{
			throw new RuntimeException("No more");
			
			
		}
		Node max= arr[1];
		return max;
	}
	public void doesNodeExist(Node newNode) {

	}

	public String popAllNodes() {
		
		String mystring="";
		for(Node node : arr)
		{
			if(node!=null){
				mystring=mystring+" "+node.toString();
			}
		}
		return mystring;

	}
	int max(Node[]arr, int parentIndex)
	{
		Node leftnode =(parentIndex*2<=counter?arr[parentIndex*2]:null);
		Node rightnode=(parentIndex*2<=counter?arr[parentIndex*2+1]:null);
		int biggernode=0;
		if(rightnode==null && leftnode!=null)
		{
			biggernode=	parentIndex*2;
		}
		if(leftnode!=null && rightnode!=null){
			if (leftnode.value>rightnode.value)
			{
				biggernode=parentIndex*2;
			}
			else
			{
				biggernode= parentIndex*2+1;
			}
		}
		
		
		return biggernode;
		
	}
}

class Node {
	public Node(int value)
	{
		this.value=value;
	}
	int value;
	public String toString()
	{
		return String.valueOf(value);
	}


}
