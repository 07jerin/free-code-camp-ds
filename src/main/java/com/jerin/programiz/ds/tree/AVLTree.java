package com.jerin.programiz.ds.tree;

import com.jerin.common.structures.ds.Node;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	public AVLTree(T rootData) {
		super(rootData);
		getRootNode().setHeight(0);
	}

	public AVLTree(Node<T> root) {
		this(root.getData());
		loadTreeData(root.getLeftNode());
		loadTreeData(root.getRightNode());
	}

	private void loadTreeData(Node<T> newNode) {
		if (newNode == null) {
			return;
		}
		insert(newNode.getData());
		if (newNode.getLeftNode() != null) {
			loadTreeData(newNode.getLeftNode());
		}
		if (newNode.getRightNode() != null) {
			loadTreeData(newNode.getRightNode());
		}
	}

	@Override
	public void insert(T data) {
		setRootNode(insert(getRootNode(), data));
	}

	private Node<T> insert(Node<T> node, T data) {
		boolean dataInsert = false;
		if (node == null || node.getData() == null) {
			node = new Node<T>(null, null, data);
			dataInsert = true;
		}
		int cmp = data.compareTo(node.getData());
		if (cmp <= 0 && !dataInsert) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else if (cmp > 0) {
			node.setRightNode(insert(node.getRightNode(), data));
		}

		updateBfAndHeight(node);
		return balance(node);

	}

	private void updateBfAndHeight(Node<T> node) {
		int leftHeight = node.getLeftNode() != null ? node.getLeftNode().getHeight() : -1;
		int rightHeight = node.getRightNode() != null ? node.getRightNode().getHeight() : -1;

		node.setHeight(Math.max(leftHeight, rightHeight) + 1);
		node.setBf(rightHeight - leftHeight);

	}

	private Node<T> balance(Node<T> node) {
		Node<T> newRoot = node;
		if (node.getBf() == -2) {
			// Left Heavy
			if (node.getLeftNode().getBf() > 0) {
				// Left Right Case, convert to left left case
				node.setLeftNode(rotateLeft(node.getLeftNode()));
			}
			// Now rotate right
			newRoot = rotateRight(node);
		} else if (node.getBf() == 2) {
			// Right Heavy
			if (node.getRightNode().getBf() < 0) {
				// Left Right Case, convert to right right case
				node.setRightNode(rotateRight(node.getRightNode()));
			}
			// Now rotate right
			newRoot = rotateLeft(node);
		}
		
		return newRoot;

	}

	private Node<T> rotateLeft(Node<T> node) {
		Node<T> newRoot = node.getRightNode();
		node.setRightNode(newRoot.getLeftNode());
		newRoot.setLeftNode(node);
		updateBfAndHeight(node);
		updateBfAndHeight(newRoot);
		return newRoot;
	}

	private Node<T> rotateRight(Node<T> node) {
		Node<T> newRoot = node.getLeftNode();
		node.setLeftNode(newRoot.getRightNode());
		newRoot.setRightNode(node);
		updateBfAndHeight(node);
		updateBfAndHeight(newRoot);
		return newRoot;
	}

	@Override
	public boolean delete(T data) {
		setRootNode(this.removeData(getRootNode(), data));
		return true;
	}

	private Node<T> removeData(Node<T> node, T data) {
		if (node == null) {
			return null;
		}

		int cmp = data.compareTo(node.getData());
		if (cmp > 0) {
			node.setRightNode(removeData(node.getRightNode(), data));
		} else if (cmp < 0) {
			node.setLeftNode(removeData(node.getLeftNode(), data));
		} else {

			// Data found Remove data
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				// Leaf Node
				return null;
			} else if (node.getRightNode() == null) {
				node = node.getLeftNode();
			} else if (node.getLeftNode() == null) {
				node = node.getRightNode();
			} else if (node.getLeftNode().getHeight() > node.getRightNode().getHeight()) {
				T maxValue = getMaxValue(node.getLeftNode());
				node.setData(maxValue());
				node.setLeftNode(removeData(node.getLeftNode(), maxValue));
			} else {
				T minValue = getMinValue(node.getRightNode());
				node.setData(minValue);
				node.setRightNode(removeData(node.getRightNode(), minValue));
			}

		}

		updateBfAndHeight(node);
		return balance(node);
	}

	public boolean isAVL() {
		Node<T> node = getRootNode();
		boolean isAVL = node.getBf() > -2 && node.getBf() < 2;
		return checkAVL(node, isAVL);
	}

	private boolean checkAVL(Node<T> node, boolean isAVL) {
		isAVL = isAVL && node.getBf() > -2 && node.getBf() < 2;
		if (!isAVL) {
			return false;
		}

		if (node.getLeftNode() != null) {
			isAVL = checkAVL(node.getLeftNode(), isAVL);
		}
		if (node.getRightNode() != null && isAVL) {
			isAVL = checkAVL(node.getRightNode(), isAVL);
		}
		return isAVL;
	}
}
