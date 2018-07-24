package com.rit.java.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class MyPriorityQueue {
	
	public static void main(String[] args)
	{
		String str= "aaa bbb ccc aaa aaa bbb bbb ccc aaa";
		String[] words=str.split(" ");
		Map<String,Integer> wordmap= new HashMap<String, Integer>(); 
		PriorityQueue<MyNode> queue= new PriorityQueue<MyNode>();
		for(String word:words)
		{
			if(wordmap.get(word)!=null)
			{
				Integer count= wordmap.get(word);
				MyNode comparenode=new MyNode(count);
				//MyNode actualnode=queue.
			}
		//	queue.add(mew My)
		}
		
		
		while(queue.size()>0)
		{
			//Integer mynumber=queue.poll();
		//	System.out.println(mynumber);
		}
	}
	

}

class MyNode{
	
	private Integer occurance;
	
	public Integer getOccurance() {
		return occurance;
	}
	public void setOccurance(Integer occurance) {
		this.occurance = occurance;
	}
	private List<String> words= new ArrayList<>();
	
	
	public MyNode(Integer occurrence) {
		
	}
	public void addWord(String word)
	{
		words.add(word);
	}
	public boolean hasWord(String word)
	{
		return words.contains(word);
	}
	
	public boolean removeWord(String word)
	{
		return words.remove(word);
	}	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isequal=false;
		if(obj instanceof MyNode)
		{
			MyNode objmynode=(MyNode)obj;
			isequal=occurance.equals(objmynode);
			
		}
		return isequal;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(occurance);
	}
	
}
