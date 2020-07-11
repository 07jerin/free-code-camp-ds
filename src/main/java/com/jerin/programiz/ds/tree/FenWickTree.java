package com.jerin.programiz.ds.tree;

/**
 * All public functions are 0 based arrays
 * 
 * @author jerijose
 *
 */

public class FenWickTree {

	private int[] tree;
	private int[] originalTree;

	public FenWickTree(int[] values) {
		tree = new int[values.length + 1];
		constructTree(values);
	}

	private void constructTree(int[] values) {
		for (int i = 0; i < values.length; i++) {
			int treeIndex = i + 1;
			tree[treeIndex] += values[i];
			
			int nextIndex = treeIndex + Integer.lowestOneBit(treeIndex);
			if (nextIndex < tree.length) {
				tree[nextIndex] += tree[treeIndex];
			}

		}
		originalTree = values.clone();
	}

	
	public int getPrefixSum(int to) {
		++to; // convert to 1 based
		int sum = 0;
		while (to > 0) {
			sum += tree[to];
			to -= Integer.lowestOneBit(to);
		}
		return sum;
	}


	/**
	 * Both are inclusive
	 * @param from
	 * @param to
	 * @return
	 */
	public int getRangeSum(int from, int to) {
		return getPrefixSum(to) - getPrefixSum(from-1);

	}

	public void updateValue(int index, int value) {
		int oldValue = originalTree[index];
		++index;
		int valueDiff = value - oldValue;
		while (index < tree.length) {
			tree[index] += valueDiff;
			index += Integer.lowestOneBit(index);
		}
	}
}
