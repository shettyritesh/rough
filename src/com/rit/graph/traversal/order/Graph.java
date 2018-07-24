package com.rit.graph.traversal.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private Map<String, Vertex> mapOfVertexes = new HashMap<String, Vertex>();

	void addEdge(String from, String to) {
		Vertex fromvertex = getOrCreatetVertex(from);
		Vertex tovertex = getOrCreatetVertex(to);
		fromvertex.addNeighBour(tovertex);
	}

	private Vertex getOrCreatetVertex(String name) {
		Vertex tovertex = mapOfVertexes.get(name);
		if (tovertex == null) {
			tovertex = new Vertex(name);
			mapOfVertexes.put(name, tovertex);
		}
		return tovertex;

	}

	void dfs(String name) {
		Set<String> visited = new HashSet<>();
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex startvetex = mapOfVertexes.get(name);
		stack.push(startvetex);
		visited.add(startvetex.getName());
		while (stack.size() > 0) {
			Vertex vertex = stack.pop();
			System.out.println(vertex.getName());
			List<Vertex> neighbours = vertex.getNeighbours();
			for (Vertex neighbor : neighbours) {
				if (!visited.contains(neighbor.getName())) {
					visited.add(neighbor.getName());
					stack.push(neighbor);
				}
			}
		}

	}

	void bfs(String name) {
		Set<String> visited = new HashSet<>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Vertex startvetex = mapOfVertexes.get(name);
		queue.add(startvetex);
		visited.add(startvetex.getName());
		while (queue.size() > 0) {
			Vertex vertex = queue.remove();
			System.out.println(vertex.getName());
			List<Vertex> neighbours = vertex.getNeighbours();
			for (Vertex neighbor : neighbours) {
				if (!visited.contains(neighbor.getName())) {
					visited.add(neighbor.getName());
					queue.add(neighbor);
				}
			}
		}

	}

}

class Vertex {
	private String name;

	public String getName() {
		return name;
	}

	private List<Vertex> neighbours = new ArrayList<Vertex>();

	public Vertex(String thatname) {
		name = thatname;
	}

	public List<Vertex> getNeighbours() {
		return neighbours;
	}

	public void addNeighBour(Vertex neighbor) {
		neighbours.add(neighbor);
	}
}