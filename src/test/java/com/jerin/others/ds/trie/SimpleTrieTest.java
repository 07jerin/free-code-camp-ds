package com.jerin.others.ds.trie;

import junit.framework.TestCase;

public class SimpleTrieTest extends TestCase {

	public void testCrud() {
		SimpleTrie trie = new SimpleTrie();
		trie.insert("Jerin");
		trie.insert("Staphy");
		trie.insert("Jerin J");
		trie.insert("Jer");
		trie.insert("Sta");
		trie.insert("Marc");
		trie.insert("JJ");
		trie.insert("JJ");

		assertEquals(trie.occurence("XYZ"), 0);
		assertEquals(trie.occurence("JJ"), 2);
		assertEquals(trie.occurence("Jerin"), 1);
		assertEquals(trie.occurence("Jeri"), 0);
		assertEquals(trie.occurence("Jer"), 1);
		assertEquals(trie.occurence("Jerin Joseph"), 0);

		trie.delete("JJ");
		trie.delete("Jerin J");
		trie.delete("JJ");

		trie.insert("Jerin Joseph");
		assertEquals(trie.occurence("Jerin Joseph"), 1);
		assertEquals(trie.occurence("JJ"), 0);
		
		trie.insert("JJ");
		assertEquals(trie.occurence("JJ"), 1);

	}
}
