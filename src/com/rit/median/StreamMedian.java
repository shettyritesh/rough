package com.rit.median;

import java.util.Comparator;
import java.util.PriorityQueue;

class StreamMedian{

PriorityQueue<Integer> minQueue;
PriorityQueue<Integer> maxQueue;

public StreamMedian(){
	minQueue= new PriorityQueue<Integer>();
	maxQueue= new PriorityQueue<Integer>(Comparator.comparing(Integer::intValue).reversed());
}


public double getCurrentMedian(Integer item){
	if(maxQueue.isEmpty()){
		maxQueue.add(item);
		return item;
	}
	if(item>maxQueue.peek()){
		minQueue.add(item);
	}
	else{
		maxQueue.add(item);
	}
	rebalanceQueues();
	if((maxQueue.size()+minQueue.size())%2>0){
		PriorityQueue<Integer> bigger=getBiggerQueue();
		return bigger.peek();
		
	}
	
	
	return (maxQueue.peek()+minQueue.peek())/2.0;
	
}

PriorityQueue<Integer> getBiggerQueue(){
	return (minQueue.size()-maxQueue.size()>0?minQueue:maxQueue);

}

PriorityQueue<Integer> getSmallerQueue(){
	return (maxQueue.size()-minQueue.size()>0?minQueue:maxQueue);
}
private void rebalanceQueues(){
	PriorityQueue<Integer> smaller=getSmallerQueue();
	PriorityQueue<Integer> bigger=getBiggerQueue();
	while(bigger.size()-smaller.size()>1 ){
		Integer item=bigger.remove();
		smaller.add(item);
	}
}

}
