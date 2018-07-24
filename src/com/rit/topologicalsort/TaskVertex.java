package com.rit.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class TaskVertex {
	private String name;
	private List<String> neighbours= new ArrayList<String>();
	public List<String> getNeighbours() {
		return neighbours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskVertex(String thatname) {
	 this.name=thatname;
	}

	public void addDependency(String dependecy){
		neighbours.add(dependecy);
	}
	
}
