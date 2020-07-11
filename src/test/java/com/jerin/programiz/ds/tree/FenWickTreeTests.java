package com.jerin.programiz.ds.tree;

import junit.framework.TestCase;

public class FenWickTreeTests extends TestCase {
	
	public void testSimpleOperations(){
		FenWickTree tree = new FenWickTree(new int[]{1,2,3,4,5,6,7,8});
		assertEquals(6, tree.getPrefixSum(2));
		assertEquals(15, tree.getPrefixSum(4));
		assertEquals(12, tree.getRangeSum(2, 4)); // Since both are inclusive in range
		
		tree.updateValue(2, 10);
		assertEquals(13, tree.getPrefixSum(2));
		assertEquals(13, tree.getRangeSum(0, 2));
		assertEquals(19, tree.getRangeSum(2, 4));
		assertEquals(40, tree.getRangeSum(2, 7));
		
		tree.updateValue(3, 4);
		assertEquals(40, tree.getRangeSum(2, 7));
		
		tree.updateValue(6, 17);
		assertEquals(50, tree.getRangeSum(2, 7));
		
		tree.updateValue(7, -12);
		assertEquals(30, tree.getRangeSum(2, 7));
		
		
	}

}
