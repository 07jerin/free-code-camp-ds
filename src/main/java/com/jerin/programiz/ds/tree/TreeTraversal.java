package com.jerin.programiz.ds.tree;

import java.util.ArrayList;
import java.util.List;

import com.jerin.common.structures.ds.Node;

public class TreeTraversal<T> {

	private enum TraversalType {
		IN, PRE, POST
	};

	public List<T> inOrderTravesal(Node<T> rootNode) {
		List<T> values = new ArrayList<>();
		traverse(rootNode, values, TraversalType.IN);
		return values;
	}

	public List<T> preOrderTravesal(Node<T> rootNode) {
		List<T> values = new ArrayList<>();
		traverse(rootNode, values, TraversalType.PRE);
		return values;
	}

	public List<T> postOrderTravesal(Node<T> rootNode) {
		List<T> values = new ArrayList<>();
		traverse(rootNode, values, TraversalType.POST);
		return values;
	}

	private void traverse(Node<T> node, List<T> values, TraversalType traversalType) {

		Node<T> leftNode = node.getLeftNode();
		Node<T> rightNode = node.getRightNode();

		if (TraversalType.PRE == traversalType)
			values.add(node.getData()); // Add upfront
		if (leftNode != null) {
			traverse(leftNode, values, traversalType);
		}

		if (TraversalType.IN == traversalType)
			values.add(node.getData()); // Add when there is no more left node
		if (rightNode != null) {
			traverse(rightNode, values, traversalType);
		}

		if (TraversalType.POST == traversalType)
			values.add(node.getData()); // Add when there is no more right or left node

	}

}
