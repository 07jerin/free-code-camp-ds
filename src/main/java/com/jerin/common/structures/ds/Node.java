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

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public Node<T> getRightNode() {
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

}
