package com.rit.graph.traversal.order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Java program for different tree traversals

/* Class containing left and right child of current
node and key value*/
class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() {
		root = null;
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up" postorder
	 * traversal.
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(14);
		tree.root.right.left = new Node(22);
		tree.root.right.right = new Node(32);
		tree.root.left.right.left = new Node(12);

		System.out.println("\n\nPreorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\n\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\n\nPostorder traversal of binary tree is ");
		tree.printPostorder();

		System.out.println("\n\nDepth First ");
		tree.depthFirstUsingStack();

		System.out.println("\n\nBreadth First ");
		tree.breadthFirstUsingQueue();
		
		System.out.println("Printing Tree");
		tree.printTree();
	}

	void depthFirstUsingStack() {
		Stack<Node> stack = new Stack<Node>();

		Node node = root;
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.key + " ");

			if (node.right != null) {
				stack.push(node.right);

			}

			if (node.left != null) {

				stack.push(node.left);
			}

		}
	}

	void breadthFirstUsingQueue() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.remove();
			System.out.print(node.key + " ");

			if (node.left != null) {
				queue.add(node.left);

			}

			if (node.right != null) {
				queue.add(node.right);

			}

		}
	}
	
	void printTree() {
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.add(root);
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.remove();
			count++;

			if (node.left != null) {
				queue.add(node.left);

			}

			if (node.right != null) {
				queue.add(node.right);

			}

		}		
		
		int matrix=1;
		System.out.println("Count= "+count);
		int rem=count;
		while(rem>1) {
			rem=rem/2;
			matrix++;
		}
		if(Math.pow(2, matrix)<count) {
			matrix++;
		}
		int width=(int)(Math.pow(2, matrix)-1);
		System.out.println("Size of Right size="+width);
		
		String[][]arr=new String[matrix][width];
		Queue<NodePosition>queue_with_pos= new LinkedList<NodePosition>();
		queue_with_pos.add(new NodePosition(root,0,width,0));
		NodePosition nodepos = null;
		int depth=0;
		while (!queue_with_pos.isEmpty()) {
			nodepos = queue_with_pos.remove();
			node=nodepos.node;
			count++;
			depth=nodepos.depth;
			

			int pivot =nodepos.start+((nodepos.end-nodepos.start)/2);
			arr[depth][pivot]=String.valueOf(node.key);
			if (node.left != null) {
				queue_with_pos.add(new NodePosition(node.left,nodepos.start,pivot,depth+1));

			}

			if (node.right != null) {
				queue_with_pos.add(new NodePosition(node.right,pivot+1,nodepos.end,depth+1));				
			}

		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if (arr[i][j]==null){
					System.out.print("  ");
				}
				else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
			
		}
	}
}

class NodePosition{
	Node node;
	int start;
	int end;
	int depth;
	public NodePosition(Node currNode,int arrstart,int arrend,int graphdepth) {
		node=currNode;
		start=arrstart;
		end=arrend;
		depth=graphdepth;
	}
}
