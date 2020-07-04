package com.jerin.programiz.ds.tree;

import java.util.List;

import com.jerin.common.utils.ListUtils;

import junit.framework.TestCase;

public class TreeTraversalTest extends TestCase {

	Tree<Integer> simpleTree;

	protected void setUp() {
		simpleTree = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
	}

	public void testTraversal() {
		List<Integer> inOrderList = simpleTree.inOrderTravesal();
		assertEquals("1,2,3,4,5,6,7,8,9", ListUtils.getCommaSeparatedString(inOrderList));

		List<Integer> preOrderList = simpleTree.preOrderTravesal();
		assertEquals("5,3,1,2,4,8,6,7,9", ListUtils.getCommaSeparatedString(preOrderList));

		List<Integer> postOrderList = simpleTree.postOrderTravesal();
		assertEquals("2,1,4,3,7,6,9,8,5", ListUtils.getCommaSeparatedString(postOrderList));
	}

}
