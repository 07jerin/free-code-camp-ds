package com.jerin.common.structures.ds;

public class Node<T> {

	private Node<T> leftNode;
	private Node<T> rightNode;
	private T data;
	private int height;
	private int bf;

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

	//TODO: Implement the print method to print the tree
	private String toString(int level) {

		StringBuilder sbt = new StringBuilder();
		int count = level;
		while (count > 0) {
			sbt.append("\t \t");
			count--;
		}
		StringBuilder sb = new StringBuilder("");
		String leftData = this.leftNode != null ? this.leftNode.toString(++level) : "null";
		String rightData = this.rightNode != null ? this.rightNode.toString(++level) : "null";
		sb.append("  [ ");
		sb.append("Data:" + this.data);
		sb.append(" BF:" + this.getBf());
		sb.append(" Height:" + this.getHeight());
		sb.append("\n" + sbt.toString() + " Left  :" + "\n" + sbt.toString() + leftData);
		sb.append("\n" + sbt.toString() + " Right : " + "\n" + sbt.toString() + rightData);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		String leftData = this.leftNode != null ? this.leftNode.getData().toString() : "null";
		String rightData = this.rightNode != null ? this.leftNode.getData().toString() : "null";
		sb.append("Data:" + this.data);
		sb.append(" BF:" + this.getBf());
		sb.append(" Height:" + this.getHeight());
		sb.append(" Left  :" + leftData);
		sb.append(" Right : " + rightData);
		return sb.toString();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBf() {
		return bf;
	}

	public void setBf(int bf) {
		this.bf = bf;
	}

}
