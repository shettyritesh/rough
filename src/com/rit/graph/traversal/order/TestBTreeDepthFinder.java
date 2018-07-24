package com.rit.graph.traversal.order;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestBTreeDepthFinder {

	@Test
	@Ignore
	public void testGetMaxDepth() {
		BTree tree= new BTree();
		tree.root = new MyNode(1);
		tree.root.left = new MyNode(2);
		tree.root.right = new MyNode(3);
		tree.root.left.left = new MyNode(4);
		tree.root.left.right = new MyNode(5);
		tree.root.right.left = new MyNode(6);
		tree.root.right.right = new MyNode(7);
		tree.root.left.right.left = new MyNode(8);		
		int depth=tree.getMaxDepth();
		assertTrue(depth==4);
		//tree.bfs();
		
	}
	@Test
	@Ignore
	public void testGetBFS() {
		BTree tree= new BTree();
		tree.root = new MyNode(1);
		tree.root.left = new MyNode(2);
		tree.root.right = new MyNode(3);
		tree.root.left.left = new MyNode(4);
		tree.root.left.right = new MyNode(5);
		tree.root.right.left = new MyNode(6);
		tree.root.right.right = new MyNode(7);
		tree.root.left.right.left = new MyNode(8);		
		tree.bfs();
		
	}
	@Test
	@Ignore
	public void testGetNodeAddBFS() {
		BTree tree= new BTree();
		tree.addNode(new MyNode(1));
		tree.addNode(new MyNode(2));
		tree.addNode(new MyNode(3));
		tree.addNode(new MyNode(4));
		tree.addNode(new MyNode(5));
		tree.addNode(new MyNode(6));
		tree.addNode(new MyNode(7));
		tree.addNode(new MyNode(8));
		tree.bfs();
		
	}
	
	@Test
	@Ignore
	public void testIsTreeBalanced() {
		BTree tree= new BTree();
		tree.root = new MyNode(1);
		tree.root.left = new MyNode(2);
		tree.root.right = new MyNode(3);
		tree.root.left.left = new MyNode(4);
		tree.root.left.right = new MyNode(5);
		tree.root.right.left = new MyNode(6);
		tree.root.right.right = new MyNode(7);
		tree.root.left.right.left = new MyNode(8);		
		boolean isbalanced=tree.isTreeSuperBalanced();
		assertTrue(isbalanced);
		
	}	
	@Test
	public void testIsTreeNotBalanced() {
		BTree tree= new BTree();
		tree.root = new MyNode(1);
		tree.root.left = new MyNode(2);
		tree.root.right = new MyNode(3);
		tree.root.left.left = new MyNode(4);
		tree.root.left.right = new MyNode(5);
		tree.root.right.left = new MyNode(6);
		tree.root.right.right = new MyNode(7);
		tree.root.left.right.left = new MyNode(8);		
		tree.root.left.right.left.right = new MyNode(9);
		boolean isbalanced=tree.isTreeSuperBalanced();
		assertTrue(!isbalanced);
		
	}
}
