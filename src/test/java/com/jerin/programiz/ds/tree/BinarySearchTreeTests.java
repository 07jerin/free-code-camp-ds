package com.jerin.programiz.ds.tree;

import junit.framework.TestCase;

public class BinarySearchTreeTests extends TestCase {


	protected void setUp() {
		
	}

	public void testIsPresent() {
		Tree<Integer> binayTree  = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
		assertEquals(true, binayTree.isPresent(1));
		assertEquals(true, binayTree.isPresent(2));
		assertEquals(false, binayTree.isPresent(10));
		assertEquals(false, binayTree.isPresent(-1));
		assertEquals(true, binayTree.isPresent(5));
		assertEquals(false, binayTree.isPresent(0));
	}
	
	
	public void testInsert() {
		Tree<Integer> binayTree = new BinarySearchTree<Integer>(10);
		binayTree.insert(30);
		binayTree.insert(20);
		assertEquals("10,20,30", binayTree.toString());
		binayTree.insert(15);
		binayTree.insert(12); 
		binayTree.insert(35); 
		binayTree.insert(30); 
		binayTree.insert(19); 
		assertEquals("10,12,15,19,20,30,30,35", binayTree.toString()); 
		
	}
	
	public void testDelete() {
		Tree<Integer> binayTree  = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
		binayTree.delete(5);
		assertEquals("1,2,3,4,6,7,8,9",  binayTree.toString());
		binayTree.delete(7);
		assertEquals("1,2,3,4,6,8,9",  binayTree.toString());
		
		binayTree.delete(1);
		assertEquals("2,3,4,6,8,9",  binayTree.toString());
		
		binayTree.delete(100);
		assertEquals("2,3,4,6,8,9",  binayTree.toString());
		binayTree.delete(2);
		binayTree.delete(3);
		binayTree.delete(4);
		binayTree.delete(6);
		binayTree.delete(8);
		assertEquals("9",  binayTree.toString());
		
		binayTree.delete(9);
		assertEquals("",  binayTree.toString());		
	}
	
	
	public void testCrud() {
		Tree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
		binayTree.insert(4);
		binayTree.insert(56); 
		binayTree.insert(8); 
		binayTree.insert(9); 
		binayTree.insert(12); 
		
		assertEquals("4,8,9,12,20,56",  binayTree.toString());
		assertEquals(true, binayTree.isPresent(8));
		assertEquals(false, binayTree.isPresent(10));
		
		binayTree.delete(56);
		binayTree.delete(4);
		assertEquals("8,9,12,20",  binayTree.toString());
		
	}
	

}
