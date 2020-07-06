package com.jerin.others.ds.trie;

public class SimpleTrie {
	TrieNode root = new TrieNode();

	public void insert(String val) {
		TrieNode[] nodes = root.getNodes();
		TrieNode leafNode = null;
		for (Character c : val.toCharArray()) {
			if (nodes[c] == null) {
				nodes[c] = new TrieNode();
			}
			leafNode = nodes[c];
			nodes = leafNode.getNodes();

		}
		leafNode.incrementTerminatingCount();
	}

	public void delete(String val) {
		TrieNode[] nodes = root.getNodes();
		TrieNode leafNode = null;
		for (Character c : val.toCharArray()) {
			if (nodes[c] == null) {
				System.out.println("No Data to delete");
			}
			leafNode = nodes[c];
			nodes = leafNode.getNodes();
		}
		leafNode.decrementTerminatingCount();
	}

	public int occurence(String val) {
		TrieNode[] nodes = root.getNodes();
		TrieNode leafNode = null;
		for (Character c : val.toCharArray()) {
			if (nodes[c] == null) {
				return 0;
			}
			leafNode = nodes[c];
			nodes = leafNode.getNodes();
		}
		return leafNode.getTerminatingCount();
	}

}
