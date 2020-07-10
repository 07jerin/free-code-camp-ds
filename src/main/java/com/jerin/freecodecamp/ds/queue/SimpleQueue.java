package com.jerin.freecodecamp.ds.queue;

import com.jerin.freecodecamp.ds.list.DoublyLinkedList;

public class SimpleQueue<T> {

	private DoublyLinkedList<T> data;

	public SimpleQueue() {
		data = new DoublyLinkedList<>();
	}

	public void add(T element) {
		data.add(element);
	}

	public T poll() {
		T currentData = peek();
		data.removeFromTail();
		return currentData;

	}

	public T peek() {
		return data.get(0);
	}

}
