package com.rit.graph.traversal.order;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGraph {

	@Test
	public void testDfs() {
		Graph graph = new Graph();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "F");
		graph.addEdge("B", "D");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("D", "E");
		System.out.println("DFS");
		graph.dfs("A");
		System.out.println("BFS");
		graph.bfs("A");
	}

}
