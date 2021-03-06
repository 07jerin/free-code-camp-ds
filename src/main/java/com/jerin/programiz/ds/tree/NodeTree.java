package com.jerin.programiz.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jerin.common.structures.ds.Node;
import com.jerin.common.structures.ds.TreeTraversalType;

public abstract class NodeTree<T> implements Tree<T> {

	private Node<T> rootNode;

	public NodeTree(Node<T> root) {
		this.rootNode = root;
	}

	public abstract boolean isPresent(T t);

	public abstract void insert(T data);

	public abstract boolean delete(T data);

	@Override
	public List<T> inOrderTravesal() {
		List<T> values = new ArrayList<>();
		traverse(this.rootNode, values, TreeTraversalType.IN);
		return values;
	}

	@Override
	public List<T> preOrderTravesal() {
		List<T> values = new ArrayList<>();
		traverse(this.rootNode, values, TreeTraversalType.PRE);
		return values;
	}

	@Override
	public List<T> postOrderTravesal() {
		List<T> values = new ArrayList<>();
		traverse(this.rootNode, values, TreeTraversalType.POST);
		return values;
	}

	protected T getMaxValue(Node<T> tree) {
		Node<T> subTree = tree;
		while (subTree.getRightNode() != null) {
			subTree = subTree.getRightNode();
		}
		return subTree.getData();
	}

	@Override
	public T minValue() {
		return getMinValue(rootNode);
	}

	@Override
	public T maxValue() {
		return getMaxValue(rootNode);
	}

	protected T getMinValue(Node<T> tree) {
		Node<T> subTree = tree;
		while (subTree.getLeftNode() != null) {
			subTree = subTree.getLeftNode();
		}
		return subTree.getData();
	}

	private void traverse(Node<T> node, List<T> values, TreeTraversalType traversalType) {

		Node<T> leftNode = node.getLeftNode();
		Node<T> rightNode = node.getRightNode();

		if (TreeTraversalType.PRE == traversalType)
			values.add(node.getData()); // Add upfront
		if (leftNode != null) {
			traverse(leftNode, values, traversalType);
		}

		if (TreeTraversalType.IN == traversalType)
			values.add(node.getData()); // Add when there is no more left node
		if (rightNode != null) {
			traverse(rightNode, values, traversalType);
		}

		if (TreeTraversalType.POST == traversalType)
			values.add(node.getData()); // Add when there is no more right or left node

	}

	protected Node<T> getRootNode() {
		return rootNode;
	}

	protected void setRootNode(Node<T> root) {
		if (root == null) {
			rootNode.setData(null);
			rootNode.setLeftNode(null);
			rootNode.setRightNode(null);

		} else {
			rootNode = root;
		}
	}

	@Override
	public String toString() {
		if (rootNode == null || rootNode.getData() == null)
			return "";
		return this.inOrderTravesal().stream().map(Object::toString).collect(Collectors.joining(","));
	}
	
	public void print(Node<T> node) {
//		NodePrinter.print(node);
		
	}

}
