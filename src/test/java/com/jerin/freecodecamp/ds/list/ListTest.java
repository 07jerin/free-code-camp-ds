package com.jerin.freecodecamp.ds.list;

import junit.framework.TestCase;

public class ListTest extends TestCase {

	public void testSinleLinkedList() {
		List<Integer> list = new SinlgeLinkedList<Integer>();
		this.testListSize(list);
	}

	public void testArrayList() {
		List<Integer> list = new ArrayList<>();
		this.testListSize(list);
	}

	private void testListSize(List<Integer> list) {
		list.add(1);
		list.add(2);
		assertEquals(list.size(), 2);
	}
}