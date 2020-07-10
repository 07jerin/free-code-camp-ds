package com.jerin.freecodecamp.ds.list;

import junit.framework.TestCase;

public class DoubleLinkedListTest extends TestCase {

	public void testDoubleLinkedListPopAndPeek() {
		DoublyLinkedList<String> list =  new DoublyLinkedList<>();
		list.add("A");
		assertEquals("A", list.peek());
		list.add("B");
		assertEquals("B", list.pop());
		assertEquals("A", list.peek());
		list.add("B");
		assertEquals("B", list.peek());
		
	}
}
