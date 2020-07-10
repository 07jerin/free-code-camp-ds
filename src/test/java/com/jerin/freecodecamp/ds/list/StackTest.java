package com.jerin.freecodecamp.ds.list;

import junit.framework.TestCase;

public class StackTest extends TestCase{

	public void testStack(){
		StackUsingLinkedList<String> stack = new StackUsingLinkedList<>();
		stack.push("A");
		assertEquals("A", stack.peek());
		
		stack.push("B");
		assertEquals("B", stack.peek());
		assertEquals("B", stack.pop());
		assertEquals("A", stack.pop());
		
		assertEquals(true, stack.isEmpty());
		
	
	}
}