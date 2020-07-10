package com.jerin.freecodecamp.ds.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private Object[] array;
	private int size;
	private static final int DEFAULT_SIZE = 10;

	public ArrayList() {
		this(ArrayList.DEFAULT_SIZE);
	}

	public ArrayList(int defaultSize) {
		this.array = new Object[defaultSize];
		this.size = 0;
	}

	public void add(T element) {
		checkAndResize();
		array[size] = element;
		size++;
	}

	public void add(T element, int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException();
		checkAndResize();

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = element;

	}

	public boolean remove(T element) {
		for (int i = 0; i<size; i++) {
			//TODO:
		}
		return false;
	}

	public boolean remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	public int getIndexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	private void checkAndResize() {
		if (size == array.length) {
			array = Arrays.copyOf(this.array, (size + size >> 1));
		}
	}

}
