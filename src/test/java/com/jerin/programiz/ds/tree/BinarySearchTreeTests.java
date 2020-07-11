package com.jerin.programiz.ds.tree;

import junit.framework.TestCase;

public class BinarySearchTreeTests extends TestCase {


	protected void setUp() {
		
	}

	public void testIsPresent() {
		NodeTree<Integer> binayTree  = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
		assertEquals(true, binayTree.isPresent(1));
		assertEquals(true, binayTree.isPresent(2));
		assertEquals(false, binayTree.isPresent(10));
		assertEquals(false, binayTree.isPresent(-1));
		assertEquals(true, binayTree.isPresent(5));
		assertEquals(false, binayTree.isPresent(0));
	}
	
	
	public void testInsert() {
		NodeTree<Integer> binayTree = new BinarySearchTree<Integer>(10);
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
	
	public void testSimpleDelete() {
		NodeTree<Integer> binayTree  = new BinarySearchTree<Integer>(4);
		binayTree.insert(3);
		binayTree.insert(5);
		binayTree.delete(5);
		assertEquals("3,4",  binayTree.toString());
		binayTree.insert(5);
		binayTree.delete(3);
		assertEquals("4,5",  binayTree.toString());
	}
	
	public void testDelete() {
		NodeTree<Integer> binayTree  = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
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
		NodeTree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
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
		binayTree.delete(8);
		binayTree.delete(9);
		binayTree.delete(20);
		binayTree.delete(12);
		assertEquals("",  binayTree.toString());
		binayTree.insert(4);
		assertEquals("4",  binayTree.toString());
		binayTree.insert(3);
		assertEquals("3,4",  binayTree.toString());
	}
	
	public void testFullTree() {
		BinarySearchTree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
		binayTree.insert(4);
		assertEquals(false, binayTree.isFullTree());
		
		binayTree.insert(56); 
		assertEquals(true, binayTree.isFullTree());
		
		binayTree.insert(10);
		binayTree.insert(2);
		assertEquals(true, binayTree.isFullTree());
		
		binayTree.insert(15);
		assertEquals(false, binayTree.isFullTree());
		
		binayTree.insert(6);
		assertEquals(true, binayTree.isFullTree());
		
		binayTree.insert(40);
		assertEquals(false, binayTree.isFullTree());
		
		binayTree.insert(60);
		assertEquals(true, binayTree.isFullTree());
		
		binayTree.insert(70);
		binayTree.insert(80);
		assertEquals(binayTree.isFullTree(), false);
		
	}
	
	public void testisPerfectTree() {
		BinarySearchTree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
		binayTree.insert(4);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(56); 
		assertEquals(true, binayTree.isPerfect());
		
		binayTree.insert(10);
		binayTree.insert(2);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(15);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(6);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(40);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(60);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(70);
		binayTree.insert(58);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(50);
		binayTree.insert(30);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(1);
		assertEquals(false, binayTree.isPerfect());
		
		binayTree.insert(3);
		assertEquals(true, binayTree.isPerfect());
		
		binayTree.delete(1);
		assertEquals(false, binayTree.isPerfect());
		binayTree.insert(1);
		assertEquals(true, binayTree.isPerfect());
		
		
	}
	
	public void testLevlOrderTraversal() {
		BinarySearchTree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
		binayTree.insert(4);
		binayTree.insert(50); 
		assertEquals(",20,4,50", binayTree.levelOrderTraversal());
		
		binayTree.insert(30); 
		binayTree.insert(8); 
		binayTree.insert(9); 
		assertEquals(",20,4,50,8,30,9", binayTree.levelOrderTraversal());
		
		binayTree.insert(12); 
		binayTree.insert(70); 
		assertEquals(",20,4,50,8,30,70,9,12", binayTree.levelOrderTraversal());
	}
	
	public void testheight() {
		BinarySearchTree<Integer> binayTree  = new BinarySearchTree<Integer>(20);
		binayTree.insert(4);
		binayTree.insert(50); 
		assertEquals(1, binayTree.height());
		
		binayTree.insert(30); 
		binayTree.insert(8); 
		binayTree.insert(9); 
		assertEquals(3, binayTree.height());
		
		binayTree.insert(12); 
		binayTree.insert(70); 
		assertEquals(4, binayTree.height());
		
		binayTree.insert(41); 
		binayTree.insert(42); 
		assertEquals(4, binayTree.height());
		
		binayTree.insert(42); 
		assertEquals(5, binayTree.height());
	}
	
	
	

}
