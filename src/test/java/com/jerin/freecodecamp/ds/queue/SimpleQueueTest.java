package com.jerin.freecodecamp.ds.queue;

import junit.framework.TestCase;

public class SimpleQueueTest extends TestCase {

	public void testQueue() {
		SimpleQueue<String> queue = new SimpleQueue<String>();
		queue.add("A");
		queue.add("B");
		assertEquals("A", queue.peek());
		assertEquals("A", queue.poll());
		assertEquals("B", queue.poll());
		
		queue.add("A");
		queue.add("B");
		queue.add("C");
		assertEquals("A", queue.poll());
	}
}
