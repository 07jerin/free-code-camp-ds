package com.jerin.freecodecamp.ds.list;

public class DoublyLinkedList<T> implements List<T> {

	private DoubleLinkedNode<T> head;
	private DoubleLinkedNode<T> tail;
	private int count;

	public DoublyLinkedList() {
		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(null);
		head = node;
		tail = node;
	}

	private class DoubleLinkedNode<U> {
		T data;
		DoubleLinkedNode<T> next;
		DoubleLinkedNode<T> prev;

		DoubleLinkedNode(T data) {
			this.data = data;
		}
	}

	@Override
	public void add(T element) {
		if (head.data == null) {
			head.data = element;
		} else {
			insertDataAtHead(element);
		}
		count++;
	}

	private void insertDataAtHead(T element) {
		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(element);
		head.prev = node;
		node.next = head;
		head = node;
	}

	private void insertAtTail(T element) {
		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(element);
		node.prev = tail;
		tail.next = node;
		tail = node;
		count++;
	}

	@Override
	public void add(T element, int index) throws IndexOutOfBoundsException {
		if (index >= count) {
			throw new RuntimeException("Cant insert in this index");
		}
		if (index == 0) {
			insertAtTail(element);
			return;
		}

		DoubleLinkedNode<T> currentIndexNode = tail;
		while (index > 0) {
			currentIndexNode = currentIndexNode.prev;
			index--;
		}

		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(element);
		node.next = currentIndexNode.next;
		node.prev = currentIndexNode;

		currentIndexNode.next = node;
		node.next.prev = node;
		count++;

	}
	
	public T pop() {
		T data = this.peek();
		DoubleLinkedNode<T> nextNode = head.next;
		if(null != nextNode) {
			nextNode.prev =null;
			head = nextNode;
		}else {
			head.data = null;
		}
		count --;
		return data;
	}
	
	public T peek() {
		if(count ==0) {
			throw new RuntimeException("Stack is emppty");
		}
		T data = head.data;
		return data;
	}

	public boolean removeFromTail() {
		if (count == 1) {
			tail.data = null;
		} else {
			DoubleLinkedNode<T> oldTail = tail;
			tail = oldTail.prev;
			tail.next = null;
			oldTail.prev = null;
		}
		count--;
		return true;
	}

	@Override
	public boolean remove(T element) {

		DoubleLinkedNode<T> currentIndexNode = tail;
		if (element == currentIndexNode.data) {
			removeFromTail(); // Head == tail == data node
			return true;
		}

		int removeIndex = 1;
		DoubleLinkedNode<T> nodeToRemove = null;
		while (removeIndex < count) {
			currentIndexNode = currentIndexNode.prev;
			if (element == currentIndexNode.data) {
				nodeToRemove = currentIndexNode;
			}
			removeIndex++;
		}
		if (nodeToRemove != null) {
			if (removeIndex == count - 1) {
				unlinkHeadNode();
			} else {
				unlinkNode(nodeToRemove);
			}
			return true;
		}
		return false;
	}
	

	@Override
	public boolean remove(int index) throws IndexOutOfBoundsException {
		if (index >= count) {
			throw new RuntimeException("Cant remove from this index");
		}
		if (index == 0) {
			removeFromTail();
			return true;
		}
		if (index == count - 1) {
			unlinkHeadNode();
			return true;
		}

		DoubleLinkedNode<T> currentIndexNode = tail;
		while (index > 1) {
			currentIndexNode = currentIndexNode.prev;
			index--;
		}

		unlinkNode(currentIndexNode);
		return true;
	}

	private void unlinkNode(DoubleLinkedNode<T> currentIndexNode) {
		DoubleLinkedNode<T> previousNode = currentIndexNode.prev;
		DoubleLinkedNode<T> nextNode = currentIndexNode.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;

		count--;
	}

	private void unlinkHeadNode() {
		DoubleLinkedNode<T> oldHead = head;
		head = oldHead.next;
		head.prev = null;
		oldHead.next = null;
		count--;
	}

	@Override
	public int getIndexOf(T element) {
		int index = 0;
		DoubleLinkedNode<T> currentIndexNode = tail;

		while (index < count) {
			if (element == currentIndexNode.data) {
				return index;
			}
			currentIndexNode = currentIndexNode.prev;
			index++;
		}
		return -1;
	}

	@Override
	public T get(int index) {
		if (index >= count) {
			throw new RuntimeException("Index out of bound");
		}

		DoubleLinkedNode<T> currentIndexNode = tail;
		index--;
		while (index >= 0) {
			currentIndexNode = currentIndexNode.prev;
			index--;
		}
		return currentIndexNode.data;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public void clear() {

		head.next = null;
		head.prev = null;
		head.data = null;
		tail = head;
		count = 0;

	}

	public String traveseForward() {
		StringBuilder sb = new StringBuilder();
		if (count == 0) {
			return "";
		}

		DoubleLinkedNode<T> currentNode = head;
		while (currentNode != null) {
			sb.append(currentNode.data);
			sb.append(",");
			currentNode = currentNode.next;
		}
		return sb.toString();
	}

	public String traveseBack() {
		StringBuilder sb = new StringBuilder();
		if (count == 0) {
			return "";
		}

		DoubleLinkedNode<T> currentNode = tail;
		while (currentNode != null) {
			sb.append(currentNode.data);
			sb.append(",");
			currentNode = currentNode.prev;
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return traveseBack();
	}

}
