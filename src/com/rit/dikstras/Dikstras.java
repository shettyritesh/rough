package com.rit.dikstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Dikstras {
	private Map<String, String> mapOfPredecessor= new HashMap<String, String>();
	private Map<String, Integer> distances= new HashMap<String, Integer>();


	public String getFastestPath(String from, String to)
	{
		String result="";
		
		Graph graph= new Graph();
		graph.addEdge("A", "B", 3);
		graph.addEdge("A", "C", 1);
		graph.addEdge("A", "K", 1);
		
		graph.addEdge("B", "D", 1);
		graph.addEdge("B", "E", 3);
		graph.addEdge("B", "K", 1);
		
		graph.addEdge("C", "K", 1);
		
		graph.addEdge("K", "D", 1);
		
		graph.addEdge("D", "E", 1);
		return result;
	}
}


class Graph{
	
	private Map<String, Vertex> mapOfVertex= new HashMap<String, Vertex>();
	private Map<String, Integer> mapOfweight= new HashMap<String, Integer>();
	public void addEdge(String one, String two, int weight){
		Vertex vone=mapOfVertex.get(one);
		if(vone==null){
			vone= new Vertex(one);
		}
		Vertex vtwo=mapOfVertex.get(two);
		Edge newedge= null;
		if(vtwo==null){
			vtwo= new Vertex(two);
		}
		if (one.compareTo(two)<0)
		{
			newedge= new Edge(vone, vtwo, weight);
		}
		else
		{
			newedge= new Edge(vtwo, vone, weight);
		}

		
	}
	
}

class Vertex{
	
	private String label;
	private List<Edge> neighbourhood= new ArrayList<Edge>();
	@Override
	public int hashCode()
	{
		
		return label.hashCode();
		
	}
	@Override
	public boolean equals(Object obj) {
		boolean isequal=false;
		if(obj instanceof String){
			isequal= label.equals((String)obj);
		}
		return isequal;
	}
	public Vertex(String label) {
		super();
		this.label = label;
	}
	
	public void addNeighbour(Edge edge){
		neighbourhood.add(edge);
	}
	
	public List<Edge> getNeighbours()
	{
		return neighbourhood;
	}
}

class Edge implements Comparable<Edge>{
	private Vertex one;	
	private Vertex two;
	int weight;

	public Edge(Vertex one, Vertex two, int weight) {
		super();
		this.one = one;
		this.two = two;
		this.weight = weight;
	}
	@Override
	public boolean equals(Object obj) {
		boolean isEqual= false; 
		if (obj instanceof Edge)
		{
			Edge that= (Edge)obj;
			if (this.one.equals(that.one) &&this.two.equals(that.two) )
			{
				isEqual=true;
			}
		}
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(one,two);
	}

	public Vertex getOne() {
		return one;
	}
	public void setOne(Vertex one) {
		this.one = one;
	}
	public Vertex getTwo() {
		return two;
	}
	public void setTwo(Vertex two) {
		this.two = two;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge that) {
		
		return this.getWeight()-that.getWeight();
	}
	
}