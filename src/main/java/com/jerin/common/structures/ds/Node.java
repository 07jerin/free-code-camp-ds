package com.jerin.common.structures.ds;

public class Node<T> {

	private Node<T> leftNode;
	private Node<T> rightNode;
	private T data;

	public Node(Node<T> leftNode, Node<T> righNode, T data) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = righNode;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public Node<T> getLeftNode(boolean constructNew) {
		if (leftNode == null && constructNew) {
			leftNode = new Node<T>(null, null, null);
		}
		return leftNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public Node<T> getRightNode() {
		return rightNode;
	}

	public Node<T> getRightNode(boolean constructNew) {
		if (rightNode == null && constructNew) {
			rightNode = new Node<T>(null, null, null);
		}
		return rightNode;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isLeafNode() {
		return this.leftNode == null && this.rightNode == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data :" + this.data);
		sb.append("Left :" + this.leftNode != null ? this.leftNode.toString() : "null");
		sb.append("Right :" + this.rightNode != null ? this.rightNode.toString() : "null");
		return sb.toString();
	}

}
