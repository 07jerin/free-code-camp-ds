package com.jerin.freecodecamp.ds.list;

public class StackUsingLinkedList<T> {

	DoublyLinkedList<T> dataStore = new DoublyLinkedList<>();

	public void push(T element) {
		dataStore.add(element);
	}

	public T pop() {
		return dataStore.pop();
	}

	public T peek() {
		return dataStore.peek();
	}

	public boolean isEmpty() {
		return dataStore.isEmpty();
	}

}
