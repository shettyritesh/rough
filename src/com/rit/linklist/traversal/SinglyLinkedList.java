package com.rit.linklist.traversal;

public class SinglyLinkedList {
	Node root= new Node();
	public void add(Node newnode)
	{
		Node node= root;
		while(node.next!=null)
		{
			node=node.next;
		}
		node.next=newnode;
	}
	public void print()
	{
		Node node= root;
		while(node.next!=null)
		{
			System.out.println(node.next.value);
			node=node.next;
		}
		
		
	}
	public boolean isCyclic()
	{
		boolean iscyclic=false;
		Node node= root.next;
		Node fast= node;
		while(node!=null)
		{
			if((fast.next!=null)&&(fast.next.next!=null))
			{
				fast=fast.next.next;
				if(node==fast)
				{
					iscyclic=true;
					break;
				}
			}
			node=node.next;
		}
		
		return iscyclic;
		
	}
	
	public Node fixCyclic()
	{
		boolean iscyclic=false;
		Node node= root.next;
		Node fast= node;
		while(node!=null)
		{
			if((fast.next!=null)&&(fast.next.next!=null))
			{
				fast=fast.next.next;
				if(node==fast)
				{
					iscyclic=true;
					break;
				}
			}
			node=node.next;
		}
		if(node!=null){
			node.next=root;
		}
		return node;
		
	}	
	public void reverse()
	{
		Node prev=null;
		Node node= root.next;
		while(node!=null)
		{
			Node next=node.next;
			node.next=prev;
			prev=node;
			node=next;
		}
		root.next=prev;
	}
}


class Node{
	
	int value;
	Node next;
	public Node(){
		next=null;
	}	
	public Node(int nodevalue){
		next=null;
		value=nodevalue;
	}
}