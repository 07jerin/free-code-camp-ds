package com.jerin.freecodecamp.ds.UnionFind;

import junit.framework.TestCase;

public class UnionFindTest extends TestCase {
	
	public void testUnionFind(){
		UnionFind<String> uf = new UnionFind<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
		
		assertEquals(1, uf.find("B"));
		assertEquals(3, uf.find("D"));
		assertEquals(1, uf.componentSize("E"));
		assertEquals(8, uf.numberOfComponent());
		
		uf.unify("A", "B");
		uf.unify("G", "H");
		
		assertEquals(2, uf.componentSize("A"));
		assertEquals(2, uf.componentSize("H"));
		assertEquals(false, uf.isConnected("A", "H"));
		
		uf.unify("A", "H");
		assertEquals(4, uf.componentSize("H"));
		assertEquals(true, uf.isConnected("A", "H"));
		assertEquals(5, uf.numberOfComponent());
		
		
		uf.unify("C", "D");
		uf.unify("D", "F");
		assertEquals(3, uf.numberOfComponent());
		assertEquals(false, uf.isConnected("A", "C"));
		assertEquals(true, uf.isConnected("D", "C"));
		
		uf.unify("A", "D");
		assertEquals(true, uf.isConnected("A", "F"));
		
		
	}
	
	

}
