package com.jerin.programiz.ds.tree;

import com.jerin.common.structures.ds.Node;

public class BinarySearchTree<T extends Comparable<T>> extends NodeTree<T> {

	public BinarySearchTree(Node<T> root) {
		super(root);
	}

	public BinarySearchTree(T rootData) {
		super(new Node<T>(null, null, rootData));
	}

	public boolean isPresent(T t) {
		return this.isDataFound(t, getRootNode());
	}

	public void insert(T data) {
		insertData(this.getRootNode(), data);
	}

	public void delete(T data) {
		Node<T> root = deleteDataFromNode(this.getRootNode(), data);
		this.setRootNode(root);
	}

	// All nodes have exactly 2 entries
	public boolean isFullTree() {
		return isFullTree(getRootNode());
	}

	// All Full tree + height is same for all leaf nodes
	public boolean isPerfect() {
		return getFullTreeDepth(getRootNode(), 0) != -1;
	}

	private int getFullTreeDepth(Node<T> subTree, int currentDepth) {
		if (subTree.getLeftNode() == null && subTree.getRightNode() == null) {
			return ++currentDepth;
		}
		if (subTree.getRightNode() == null || subTree.getLeftNode() == null) {
			return -1;
		}
		currentDepth++;
		int rightDepth = getFullTreeDepth(subTree.getRightNode(), currentDepth);
		int newLeftDepth = getFullTreeDepth(subTree.getLeftNode(), currentDepth);
		return rightDepth == newLeftDepth ? rightDepth : -1;
	}

	private boolean isFullTree(Node<T> subTree) {
		if (subTree.getLeftNode() == null && subTree.getRightNode() == null) {
			return true;
		}
		if (subTree.getRightNode() == null || subTree.getLeftNode() == null) {
			return false;
		}
		return isFullTree(subTree.getRightNode()) && isFullTree(subTree.getLeftNode());
	}

	private Node<T> deleteDataFromNode(Node<T> node, T data) {
		if (node == null) {
			return null;
		}
		if (node.getData().compareTo(data) > 0) {
			node.setLeftNode(deleteDataFromNode(node.getLeftNode(), data));
		} else if (node.getData().compareTo(data) < 0) {
			node.setRightNode(deleteDataFromNode(node.getRightNode(), data));
		} else {

			if (node.getLeftNode() == null) {
				return node.getRightNode();
			} else if (node.getRightNode() == null) {
				return node.getLeftNode();
			}

			node.setData(getMinValue(node.getRightNode()));
			node.setRightNode(deleteDataFromNode(node.getRightNode(), node.getData()));
		}
		return node;
	}

	private void insertData(Node<T> tree, T newData) {
		if (tree.getData() == null) {
			tree.setData(newData);
			return;
		}
		T currentData = tree.getData();
		if (currentData.compareTo(newData) < 1) {
			insertData(tree.getRightNode(true), newData);
		} else {
			insertData(tree.getLeftNode(true), newData);
		}
	}

	private boolean isDataFound(T data, Node<T> subTree) {
		boolean isPresent = false;
		T currentNodeData = subTree.getData();
		if (currentNodeData.equals(data)) {
			return true;
		}
		Node<T> nextSubTree = data.compareTo(currentNodeData) > 0 ? subTree.getRightNode() : subTree.getLeftNode();
		if (nextSubTree != null) {
			isPresent = isDataFound(data, nextSubTree);
		}

		return isPresent;
	}

}
