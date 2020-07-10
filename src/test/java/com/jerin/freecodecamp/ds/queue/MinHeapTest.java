package com.jerin.freecodecamp.ds.queue;

import junit.framework.TestCase;

public class MinHeapTest extends TestCase {

	public void testMinHeap() {
		MinHeap<Integer> heap = new MinHeap<Integer>(10);

		heap.insert(Integer.valueOf(10));
		heap.insert(Integer.valueOf(15));
		heap.insert(2);
		heap.insert(6);
		heap.insert(7);
		heap.insert(9);

		assertEquals(true, heap.isPresent(2));
		assertEquals(Integer.valueOf(2), heap.peek());
		assertEquals(Integer.valueOf(2), heap.poll());
		assertEquals(Integer.valueOf(6), heap.peek());
		assertEquals(false, heap.isPresent(2));

		heap.delete(9);
		assertEquals(Integer.valueOf(6), heap.peek());
		heap.delete(6);
		assertEquals(Integer.valueOf(7), heap.peek());
		heap.insert(15);
		heap.insert(2);
		assertEquals(Integer.valueOf(2), heap.peek());
		heap.delete(15);
		assertEquals(true, heap.isPresent(15)); // As there were 2 entries for 15
		assertEquals(Integer.valueOf(2), heap.poll());
		assertEquals(Integer.valueOf(7), heap.poll());
		assertEquals(Integer.valueOf(10), heap.poll());
		assertEquals(Integer.valueOf(15), heap.peek());

	}

}
