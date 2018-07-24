package com.rit.tree;

public class BinaryTree {
	
	private Node rootNode;

	
	public void addNode(Node newNode)
	{
		
		if(rootNode==null)
		{
			rootNode=newNode;
			return;
		}
		Node currentnode=rootNode;
		Node parentNode=rootNode;
		while(currentnode!=null){
			parentNode=currentnode;
			if (newNode.value<rootNode.value)
			{
				if(currentnode.left!=null){
					currentnode=currentnode.left;
				}
			}
			else
			{
				if(currentnode.right!=null){
					currentnode=currentnode.right;
				}
			}
		}
		
	}
	
	public void removeNode(Node newNode)
	{
		
	}	
	
	public void doesNodeExist(Node newNode)
	{
		
	}
	
	public void printAllNodes()
	{
		
	}	
}

class Node
{
	Node left;
	Node right;
	int value;
	

}
