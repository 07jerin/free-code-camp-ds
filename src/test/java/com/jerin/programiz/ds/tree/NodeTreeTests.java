package com.jerin.programiz.ds.tree;

import java.util.List;

import com.jerin.common.utils.ListUtils;

import junit.framework.TestCase;

public class NodeTreeTests extends TestCase {


	public void testTraversal() {
		traverse(new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree()));
	}
	
	public void testValue() {
		NodeTree<Integer> tree = new BinarySearchTree<Integer>(TreeUtils.getSample1To9Tree());
		assertEquals(Integer.valueOf(1), tree.minValue());
		assertEquals(Integer.valueOf(9), tree.maxValue());

	}
	
	public void traverse(Tree<Integer> tree) {
		List<Integer> inOrderList = tree.inOrderTravesal();
		assertEquals("1,2,3,4,5,6,7,8,9", ListUtils.getCommaSeparatedString(inOrderList));

		List<Integer> preOrderList = tree.preOrderTravesal();
		assertEquals("5,3,1,2,4,8,6,7,9", ListUtils.getCommaSeparatedString(preOrderList));

		List<Integer> postOrderList = tree.postOrderTravesal();
		assertEquals("2,1,4,3,7,6,9,8,5", ListUtils.getCommaSeparatedString(postOrderList));
	}

}
