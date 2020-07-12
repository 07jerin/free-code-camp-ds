package com.jerin.programiz.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AVLTreeTest extends BinarySearchTreeTests {
	
	public void testAllBinaryTreeOperations() {
		AVLTree<Integer> tree = new AVLTree<Integer>(TreeUtils.getSample1To9Tree());
		testIsPresent(tree);
		assertEquals(true, tree.isAVL());
		assertEquals("1,2,3,4,5,6,7,8,9", tree.toString());
		
		tree = new AVLTree<Integer>(10);
		testInsert(tree);
		assertEquals(true, tree.isAVL());
		
		tree = new AVLTree<Integer>(TreeUtils.getSample1To9Tree());
		testDelete(tree);
		assertEquals(true, tree.isAVL());
		
		tree = new AVLTree<Integer>(4);
		testSimpleDelete( tree);
		assertEquals(true, tree.isAVL());
		
		tree = new AVLTree<Integer>(20);
		testCrud(tree);
		assertEquals(true, tree.isAVL());
	}

	public void testInsertion() {
		AVLTree<Integer> tree = new AVLTree<Integer>(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);

		assertEquals(true, tree.isAVL());

		tree = new AVLTree<Integer>(20);
		int i = 125;
		while (i > 0) {
			tree.insert((int) (Math.random() * 1000));
			i--;
		}
		assertEquals(true, tree.isAVL());

		List<Integer> fromTree = tree.inOrderTravesal();
		List<Integer> fromTreeBackup = tree.inOrderTravesal();
		Collections.sort(fromTreeBackup);

		assertEquals(true, fromTree.equals(fromTreeBackup));
	}

	public void testDeletion() {
		AVLTree<Integer> tree = new AVLTree<Integer>(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);
		assertEquals(true, tree.isAVL());

		tree.delete(70);
		tree.delete(80);
		tree.delete(90);
		assertEquals(true, tree.isAVL());

		int i = 0;
		List<Integer> values = new ArrayList<Integer>();
		while (i < 125) {
			int t = (int) (Math.random() * 1000);
			tree.insert(t);
			values.add(t);
			assertEquals(true, tree.isAVL());
			i++;
		}
		assertEquals(true, tree.isAVL());

		while (i > 0) {
			int index = ((int) (Math.random() * 1000)) % i;
			tree.delete(values.get(index));
			values.remove(index);
			assertEquals(true, tree.isAVL());
			i--;
		}
		assertEquals(true, tree.isAVL());
	}

}
