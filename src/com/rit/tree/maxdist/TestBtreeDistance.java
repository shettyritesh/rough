package com.rit.tree.maxdist;

import org.junit.Test;
import static org.junit.Assert.*;

class Pair {
	int maxDepth = 0;
	int maxDistance = 0;

	public Pair(int maxdepth, int maxdistance) {
		maxDepth = maxdepth;
		maxDistance = maxdistance;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public int getMaxDistance() {
		return maxDistance;
	}
}

class BTree {
	Node root;

	public Pair postprocess(Node node, int depth) {
		Pair leftpair = null;
		Pair rightpair = null;

		if (node.left != null) {
			leftpair = postprocess(node.left, depth + 1);

		} else {
			leftpair = new Pair(depth, 0);
		}
		if (node.right != null) {
			rightpair = postprocess(node.right, depth + 1);
		} else {
			rightpair = new Pair(depth, 0);
		}

		int currMaxDepth = Math.max(leftpair.getMaxDepth(), rightpair.getMaxDepth());
		int maxdistance = leftpair.getMaxDepth()-depth + rightpair.getMaxDepth()-depth;
		maxdistance = Math.max(maxdistance, leftpair.getMaxDistance());
		maxdistance = Math.max(maxdistance, rightpair.getMaxDistance());
		Pair pair = new Pair(currMaxDepth, maxdistance);
		return pair;
	}

	public int getMaxDistance() {
		if (root == null) {
			return 0;
		}
		Pair pair = postprocess(root, 0);
		return pair.getMaxDistance();
	}

}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int val) {
		value = val;
		left = null;
		right = null;
	}
}

public class TestBtreeDistance {

	@Test
	public void testMaxDistance() {
		BTree tree = new BTree();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(100);
		tree.root.right.left = new Node(80);
		tree.root.right.right = new Node(150);
		tree.root.right.right = new Node(150);
		tree.root.right.right.left = new Node(130);
		tree.root.right.right.right = new Node(151);
		int maxD = tree.getMaxDistance();
		assertEquals(maxD, 4);
	}
}
