package com.rit.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TaskExecutor {
	private Map<String, Integer> incommingDependencies= new HashMap<String,Integer>();
	private Graph graph= new Graph();
	private Set<String> zeroDependencyList= new HashSet<>();
	public void addDependency(String from, String to){
		if(to.equals(from)){
			throw new RuntimeException("To and from cannnot be empty");
		}
		graph.addDependency(from, to);
		Integer count=incommingDependencies.get(to);
		if(count==null)
		{
			count=new Integer(1);
			incommingDependencies.put(to, count);
		}
		else
		{
			count++;
			incommingDependencies.put(to, count);
		}

		if(zeroDependencyList.contains(to))
		{
			zeroDependencyList.remove(to);
		}

		count=incommingDependencies.get(from);
		if(count==null)
		{
			count=new Integer(0);
			incommingDependencies.put(from, count);
			zeroDependencyList.add(from);
		}
		else if(count>0){
			zeroDependencyList.remove(from);
		}
		
		
	}
	
	public void printDependencies()
	{
		Stack<String> stack = new Stack<String>();
		stack.addAll(zeroDependencyList);
		while(!stack.isEmpty())
		{
			String task= stack.pop();
			System.out.println(task+" ");
			List<String> neighbours= graph.getNeighbours(task);
			for(String neighbour:neighbours){
				Integer dependencyCount=incommingDependencies.get(neighbour);
				dependencyCount--;
				incommingDependencies.put(neighbour,dependencyCount);
				if (dependencyCount==0)
				{
					stack.push(neighbour);
				}
			}

		}
	}
	

}

class Graph{
	
	private Map<String, TaskVertex> mapOfVertex= new HashMap<String,TaskVertex>();
	public void addDependency(String from, String to){
		TaskVertex fromTask=mapOfVertex.get(from);
		if(fromTask==null){
			fromTask= new TaskVertex(from);
			mapOfVertex.put(from, fromTask);
		}
		TaskVertex toTask=mapOfVertex.get(to);
		if(toTask==null){
			toTask= new TaskVertex(to);
			mapOfVertex.put(to, toTask);
		}		
		
		fromTask.addDependency(to);
	}
	public List<String> getNeighbours(String vertexname)
	{
		TaskVertex task=mapOfVertex.get(vertexname);
		
		return task.getNeighbours();
	}
}