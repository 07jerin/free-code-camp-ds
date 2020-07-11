package com.jerin.freecodecamp.ds.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> {

	private Map<T, Integer> eleToIdMap;

	private int[] id;
	private int[] componentSizes;

	private int componentCount;

	UnionFind(T[] dataSet) {
		int lenght = dataSet.length;
		eleToIdMap = new HashMap<>();
		componentCount = lenght;
		id = new int[lenght];
		componentSizes = new int[lenght];

		// Set the values to map and intialize the integer array
		for (int i = 0; i < lenght; i++) {
			eleToIdMap.put(dataSet[i], i);
			id[i] = i;
			componentSizes[i] = 1;// All components have 1 size
		}
	}

	public int componentSize(T t) {
		return componentSizes[find(t)];
	}

	public int numberOfComponent() {
		return componentCount;
	}

	public boolean isConnected(T t1, T t2) {
		return find(t1) == find(t2);
	}

	public int find(T t) {
		int originalIndex = eleToIdMap.get(t);
		int rootIndex = originalIndex;

		while (id[rootIndex] != rootIndex) {
			rootIndex = id[rootIndex];
		}

		// Path Compression
		while (id[originalIndex] != originalIndex) {
			originalIndex = id[originalIndex];
			id[originalIndex] = rootIndex;
		}

		return rootIndex;
	}

	public void unify(T first, T second) {
		int firstRoot = find(first);
		int secondRoot = find(second);

		if (firstRoot == secondRoot) {
			return;
		}

		if (componentSizes[firstRoot] < componentSizes[secondRoot]) {
			componentSizes[firstRoot] += componentSizes[secondRoot];
			id[secondRoot] = firstRoot;
		} else {
			componentSizes[secondRoot] += componentSizes[firstRoot];
			id[firstRoot] = secondRoot;
		}
		componentCount--;

	}

}