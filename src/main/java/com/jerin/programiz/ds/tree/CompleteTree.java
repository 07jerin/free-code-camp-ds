package com.jerin.programiz.ds.tree;

import java.util.Arrays;
import java.util.List;

public abstract class CompleteTree<T> implements Tree<T> {

	protected T[] storage;
	protected int elementCount;

	public CompleteTree(int defaultSize) {
		storage = (T[]) new Object[defaultSize];
	}

	protected void checkAndIncreaseSize() {
		if (storage.length == elementCount) {
			storage = Arrays.copyOf(storage, elementCount * 7);
		}
	}

	protected int insertLast(T data) {
		this.checkAndIncreaseSize();
		storage[elementCount] = data;
		elementCount++;
		return elementCount - 1;
	}

	protected int getParentIndex(int childIndex) {
		if (childIndex == 0) {
			throw new Error("Cant get parent of root");
		}
		// Since int floors we don't have to check odd /evev
		return (childIndex - 1) / 2;
	}

	protected T getLeftChild(int n) {
		return getChild(n, true);
	}

	protected T getRightChild(int n) {
		return getChild(n, false);
	}

	private T getChild(int n, boolean isLeftChild) {
		int childIndex = isLeftChild ? 2 * n + 1 : 2 * n + 2;
		if (childIndex > elementCount) {
			return null;
		}
		return storage[childIndex];
	}

	@Override
	public List<T> inOrderTravesal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> preOrderTravesal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrderTravesal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "";

	}

	@Override
	public T minValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T maxValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
