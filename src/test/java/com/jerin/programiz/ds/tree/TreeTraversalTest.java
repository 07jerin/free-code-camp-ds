package com.jerin.programiz.ds.tree;

import java.util.List;

import com.jerin.common.structures.ds.Node;
import com.jerin.common.utils.ListUtils;

import junit.framework.TestCase;

public class TreeTraversalTest extends TestCase {

	public void test() {
		List<Integer> inOrderList = new TreeTraversal<Integer>().inOrderTravesal(this.getSampleTree());
		assertEquals(ListUtils.getCommaSeparatedString(inOrderList), "1,2,3,4,5,6,7,8,9");

		List<Integer> preOrderList = new TreeTraversal<Integer>().preOrderTravesal(this.getSampleTree());
		assertEquals(ListUtils.getCommaSeparatedString(preOrderList), "5,3,1,2,4,8,6,7,9");

		List<Integer> postOrderList = new TreeTraversal<Integer>().postOrderTravesal(this.getSampleTree());
		assertEquals(ListUtils.getCommaSeparatedString(postOrderList), "2,1,4,3,7,6,9,8,5");
	}

	private Node<Integer> getSampleTree() {

		Node<Integer> _2 = new Node<Integer>(null, null, 2);

		Node<Integer> _1 = new Node<Integer>(null, _2, 1);
		Node<Integer> _4 = new Node<Integer>(null, null, 4);
		Node<Integer> _3 = new Node<Integer>(_1, _4, 3);

		Node<Integer> _7 = new Node<Integer>(null, null, 7);
		Node<Integer> _6 = new Node<Integer>(null, _7, 6);

		Node<Integer> _9 = new Node<Integer>(null, null, 9);
		Node<Integer> _8 = new Node<Integer>(_6, _9, 8);

		Node<Integer> _5 = new Node<Integer>(_3, _8, 5);

		return _5;
	}

}
