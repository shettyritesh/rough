package com.rit.median;

import java.util.PriorityQueue;
import java.util.Comparator;
public class Median {
	
	private int[] arr;
	private PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>(100);
	private PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>	(100,
			new Comparator<Integer>()
				{	public int compare(Integer first, Integer second){
					return (second-first);
					}
				}
	);
	
	public Median(int[] tmparr)
	{
		arr=tmparr;
	}
	public double getMedian()
	{
		if (arr==null)
		{
			throw new RuntimeException("Cant be null");
		}
		for(int item:arr){
			if(maxHeap.isEmpty()||item<maxHeap.peek())
			{
				maxHeap.add(item);
			}
			else{
				minHeap.add(item);
			}
			rebalance();
		}
		if (maxHeap.size()!=minHeap.size()){
			PriorityQueue<Integer> bigger= maxHeap.size()>minHeap.size()?maxHeap:minHeap;
			Integer item=bigger.peek();
			return item;
		}
		else{
			Integer item1=maxHeap.peek();
			Integer item2=minHeap.peek();
			float median = (float)(item1+item2)/2;
			return median;
		}
		

	}
	private void rebalance(){
		if (Math.abs(maxHeap.size()-minHeap.size())>1){
			PriorityQueue<Integer> bigger= maxHeap.size()>minHeap.size()?maxHeap:minHeap;
			PriorityQueue<Integer> smaller= maxHeap.size()>minHeap.size()?minHeap:maxHeap;
			
			Integer item=bigger.remove();
			smaller.add(item);
		}
		
	}
}
