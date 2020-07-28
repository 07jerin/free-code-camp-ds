package com.jerin.common.structures.ds.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class DFSSimpleAdjecencyList {
	static Set<Integer> visited = new LinkedHashSet<>();

	static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
		DFSSimpleAdjecencyList.visited = new LinkedHashSet<>();
		dfss(g.get(0), 0, g);
		return ((ArrayList<Integer>) new ArrayList<Integer>(DFSSimpleAdjecencyList.visited));
	}

	static Integer dfss(ArrayList<Integer> children, int current, ArrayList<ArrayList<Integer>> g) {
		DFSSimpleAdjecencyList.visited.add(current);
		if (children == null) {
			return current;
		}

		for (Integer child : children) {
			if (!DFSSimpleAdjecencyList.visited.contains(child)) {
				ArrayList<Integer> subChildren = g.get(child);
				dfss(subChildren, child, g);
			}
		}
		return current;
	}
}
