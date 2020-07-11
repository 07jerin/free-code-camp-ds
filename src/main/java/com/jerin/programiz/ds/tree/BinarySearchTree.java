package com.jerin.programiz.ds.tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

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

	public boolean delete(T data) {
		Node<T> root = deleteDataFromNode(this.getRootNode(), data);
		this.setRootNode(root);
		return true;
	}

	private Node<T> deleteDataFromNode(Node<T> node, T data) {
		if (node == null) {
			return null;
		}

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(deleteDataFromNode(node.getLeftNode(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(deleteDataFromNode(node.getRightNode(), data));
		} else {
			// Node found
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				// Return null if no left or right node
				return null;
			} else if (node.getLeftNode() == null) {
				// Replace with Right Node
				return node.getRightNode();
			} else if (node.getLeftNode() == null) {
				// Replace with right node
				return node.getRightNode();
			} else {
				// Set largest value from left node
				Node<T> newNode = getLargestNode(node.getLeftNode());
				node.setData(newNode.getData());

				// delete the new data from left node
				node.setLeftNode(deleteDataFromNode(node.getLeftNode(), newNode.getData()));
			}
		}
		return node;

	}

	private Node<T> getLargestNode(Node<T> node) {
		while (node.getRightNode() != null) {
			node = node.getRightNode();
		}
		return node;
	}

	public String levelOrderTraversal() {
		Queue<Node<T>> childrenQ = new ArrayBlockingQueue<>(50);
		StringBuilder sb = new StringBuilder("");
		childrenQ.add(getRootNode());
		while (childrenQ.peek() != null) {
			Node<T> node = childrenQ.poll();
			sb.append(",");
			sb.append(node.getData());
			if (node.getLeftNode() != null) {
				childrenQ.add(node.getLeftNode());
			}
			if (node.getRightNode() != null) {
				childrenQ.add(node.getRightNode());
			}
		}
		return sb.toString();
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
