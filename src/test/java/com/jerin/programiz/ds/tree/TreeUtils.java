package com.jerin.programiz.ds.tree;

import com.jerin.common.structures.ds.Node;

public class TreeUtils {
	
	public static Node<Integer> getSample1To9Tree() {

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
