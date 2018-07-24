package com.rit.graph.traversal.order;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
	private Integer min;
	public Integer getMin() {
		return min;
	}
	public Integer getMax() {
		return max;
	}
	public Pair(Integer min, Integer max) {
		super();
		this.min = min;
		this.max = max;
	}
	private Integer max;
}
public class BTree{
	
	MyNode root;
	public void addNode(MyNode node){
		if(root==null){
			root=node;
		}
		else{
			addNode(root,node);
		}
	}
	private void addNode(MyNode targetNode, MyNode newnode){
		if (newnode.value<=targetNode.value)
		{
			if(targetNode.left!=null){
				addNode(targetNode.left,newnode);
			}
			else{
				targetNode.left=newnode;
			}
		}
		else if(targetNode.right!=null)
		{
			addNode(targetNode.right,newnode);
		}
		else{
			targetNode.right=newnode;
		}

	}
	public int postOrder(MyNode node, int depth){
		int leftdepth=0;
		int rightdepth=0;
		if(node.left!=null){
			leftdepth=postOrder(node.left, depth+1);
		}
		if(node.right!=null){
			rightdepth=postOrder(node.right, depth+1);
		}
		//System.out.println(node.value);
		int[] arr=new int[3];
		arr[0]=depth;
		arr[1]=leftdepth;
		arr[2]=rightdepth;
		Arrays.sort(arr);		
		return arr[2];
	}
	
	public boolean isTreeSuperBalanced(){
		Pair pair=postOrderForDiff(root, 0);
		if (pair.getMax()- pair.getMin()>1){
			return false;
		}
		return true;
	}
	private Pair postOrderForDiff(MyNode node, int depth){
		Pair leftdepthpair=null;
		Pair rightdepthpair=null;
		Integer leftmin=Integer.MAX_VALUE;
		Integer leftmax=Integer.MIN_VALUE;
		Integer rightmin=Integer.MAX_VALUE;
		Integer rightmax=Integer.MIN_VALUE;
		
		if(node.left!=null){
			leftdepthpair=postOrderForDiff(node.left, depth+1);
			leftmax=leftdepthpair.getMax();
			leftmin=leftdepthpair.getMin();
		}
		if(node.right!=null){
			rightdepthpair=postOrderForDiff(node.right, depth+1);
			rightmax=rightdepthpair.getMax();
			rightmin=rightdepthpair.getMin();
			
		}
	
		Integer current_min=null;
		Integer current_max=null;
		if(node.left==null  && node.right==null){
			current_min=depth;	
			current_max=depth;
		}
		else{
			current_max=(leftmax>rightmax?leftmax:rightmax);
			current_min=(leftmin<rightmin?leftmin:rightmin);
		}
		
		Pair pair= new Pair(current_min,current_max);
		return pair;
	}	
	public void bfs()
	{
		Queue<MyNode> queue= new LinkedList<MyNode>();
		queue.add(root);
		
		while(queue.size()>0){
			MyNode node= queue.remove();
			System.out.println(node.value);	
			if(node.left!=null){
				queue.add(node.left);
			}
			System.out.print(" ");
			if(node.right!=null){
				queue.add(node.right);
			}
			System.out.println();
			
		}
		
	}
	public int getMaxDepth(){
		return postOrder(root,0)+1;
	}	
}

class MyNode{
	public MyNode()
	{

	}
	public MyNode(int key)
	{
		value=key;
	}
	int value;
	MyNode left;
	MyNode right;
	
}
