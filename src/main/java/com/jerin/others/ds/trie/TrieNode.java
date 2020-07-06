package com.jerin.others.ds.trie;

public class TrieNode {

	private int terminatingCount;
	private TrieNode[] nodes;
	private Character value;

	public TrieNode() {
		nodes = new TrieNode[256];
	}

	public int getTerminatingCount() {
		return terminatingCount;
	}

	public void incrementTerminatingCount() {
		terminatingCount++;
	}

	public void decrementTerminatingCount() {
		terminatingCount = terminatingCount > 0 ? --terminatingCount : 0;
	}

	public void setTerminatingCount(int terminatingCount) {
		this.terminatingCount = terminatingCount;
	}

	public TrieNode[] getNodes() {
		return nodes;
	}

	public void setNodes(TrieNode[] nodes) {
		this.nodes = nodes;
	}

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}
}
