package com.jerin.freecodecamp.ds.list;

import junit.framework.TestCase;

public class ListTest extends TestCase {

	public void testDoubleLinkedList() {
		listOperations(new DoublyLinkedList<Integer>());
	}

	public void listOperations(List<Integer> intList) {
		intList.add(10);
		assertEquals("10,", intList.toString());
		assertEquals(0, intList.getIndexOf(10));

		intList.remove(Integer.valueOf(10));
		assertEquals(-1, intList.getIndexOf(10));

		intList.add(1);
		intList.add(2);
		intList.add(3);
		assertEquals("1,2,3,", intList.toString());
		intList.clear();
		
		intList.add(10); //10
		intList.add(5, 0); // 5 10 
		assertEquals("5,10,", intList.toString());
		
		intList.add(15); // 5 10 15
		assertEquals("5,10,15,", intList.toString());
		
		intList.add(7, 1); // 5 7 10 15

		assertEquals("5,7,10,15,", intList.toString());

		intList.remove(0); //// 7 10 15
		intList.remove(2); // 7 10
		intList.add(5); // 7 10 5 
		intList.add(10); // 7 10 5 10 

		assertEquals("7,10,5,10,", intList.toString());

		assertEquals(intList.getIndexOf(5), 2);
		assertEquals(intList.getIndexOf(10), 1);
		intList.remove(0); // 10 5 10 
		assertEquals(intList.getIndexOf(10), 0);

		intList.clear();
		intList.add(5); // 5 
		intList.add(10); // 5 10
		intList.remove(Integer.valueOf(5)); // 10
		assertEquals(intList.getIndexOf(10), 0);
		
		
		assertEquals(intList.remove(Integer.valueOf(10)), true);
		assertEquals(intList.remove(Integer.valueOf(10)), false);
		assertEquals(intList.getIndexOf(10), -1);
		intList.add(10); 
		assertEquals(intList.getIndexOf(10), 0);
		
	}

}