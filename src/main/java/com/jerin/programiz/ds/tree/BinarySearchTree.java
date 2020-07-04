package com.jerin.programiz.ds.tree;

import com.jerin.common.structures.ds.Node;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

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
		deleteData(this.getRootNode(), data, this.getRootNode());
	}

	private boolean deleteData(Node<T> subTree, T data, Node<T> parentNode) {
		boolean deleted = false;
		T currentNodeData = subTree.getData();
		if (currentNodeData.equals(data)) {
			if (subTree.isLeafNode()) {
				unlinkFromParent(subTree, parentNode);
				subTree.setData(null);
			} else {
				traverseAndSwap(subTree, parentNode);
			}
			return true;
		}

		Node<T> nextSubTree = data.compareTo(currentNodeData) > 0 ? subTree.getRightNode() : subTree.getLeftNode();
		if (nextSubTree != null) {
			deleted = deleteData(nextSubTree, data, subTree);
		}

		return deleted;
	}

	private void unlinkFromParent(Node<T> subTree, Node<T> parentNode) {

		if (parentNode.getLeftNode() != null && parentNode.getLeftNode().getData().equals(subTree.getData())) {
			parentNode.setLeftNode(null);
		} else {
			parentNode.setRightNode(null);
		}
	}

	private void traverseAndSwap(Node<T> tree, Node<T> parentNode) {
		// TODO: Height balancing
		Node[] newNodes = null;
		if (tree.getLeftNode() != null) {
			newNodes = getLargestDataNode(tree.getLeftNode(), tree);
		} else if (tree.getRightNode() != null) {
			newNodes = getSmallestDataNode(tree.getRightNode(), tree);
		} else {
			unlinkFromParent(tree, parentNode);
			return;
		}

		tree.setData((T) newNodes[0].getData());
		traverseAndSwap(newNodes[0], newNodes[1]);

	}

	private Node[] getSmallestDataNode(Node<T> tree, Node<T> parentNode) {
		if (tree.getLeftNode() == null) {
			Node[] vals = { tree, parentNode };
			return vals;
		}
		return getSmallestDataNode(tree.getLeftNode(), tree);
	}

	private Node[] getLargestDataNode(Node<T> tree, Node<T> parentNode) {

		if (tree.getRightNode() == null) {
			Node[] vals = { tree, parentNode };
			return vals;
		}
		return getLargestDataNode(tree.getRightNode(), tree);
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
