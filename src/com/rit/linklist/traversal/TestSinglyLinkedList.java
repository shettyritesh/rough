package com.rit.linklist.traversal;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestSinglyLinkedList {

	SinglyLinkedList linkedlist= null;
	
	@Before
	public void setup()
	{
		linkedlist=new SinglyLinkedList();
	}
	
	@Test
	public void testAdd() {
		linkedlist.add(new Node(1));
		linkedlist.add(new Node(2));
		linkedlist.add(new Node(3));
		linkedlist.add(new Node(4));
		linkedlist.add(new Node(5));
		linkedlist.print();
		
	}

	@Test	
	public void testReverse() {
		linkedlist.add(new Node(1));
		linkedlist.add(new Node(2));
		linkedlist.add(new Node(3));
		linkedlist.add(new Node(4));
		linkedlist.add(new Node(5));		
		linkedlist.reverse();
		linkedlist.print();
	}
	@Test	
	public void testNotCyclic() {
		linkedlist.add(new Node(1));
		linkedlist.add(new Node(2));
		linkedlist.add(new Node(3));
		linkedlist.add(new Node(4));
		linkedlist.add(new Node(5));		
		boolean iscyclic=linkedlist.isCyclic();
		Assert.assertTrue(!iscyclic);
	}
	@Test	
	public void testCyclic() {
		linkedlist.add(new Node(1));
		linkedlist.add(new Node(2));
		Node node3=new Node(3);
		linkedlist.add(node3);
		linkedlist.add(new Node(4));
		Node problemnode=new Node(5);
		problemnode.next=node3;
		linkedlist.add(problemnode);		
		boolean iscyclic=linkedlist.isCyclic();
		Assert.assertTrue(iscyclic);
	}	
	
	@Test	
	public void testFixCyclic() {
		linkedlist.add(new Node(1));
		linkedlist.add(new Node(2));
		Node node3=new Node(3);
		linkedlist.add(node3);
		linkedlist.add(new Node(4));
		Node problemnode=new Node(5);
		problemnode.next=node3;
		linkedlist.add(problemnode);		
		Node problematicnode=linkedlist.fixCyclic();
		System.out.println("Problem is "+problematicnode.value);
		Assert.assertTrue(problematicnode==problemnode);
	}		
}
