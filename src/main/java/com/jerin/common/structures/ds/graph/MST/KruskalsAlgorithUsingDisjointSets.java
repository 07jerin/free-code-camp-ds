package com.jerin.common.structures.ds.graph.MST;

import java.util.LinkedList;

import com.jerin.common.structures.ds.graph.MST.KruskalaAlgorithm.Edge;

public class KruskalsAlgorithUsingDisjointSets {

	public static void usingDisjointSets(LinkedList<Edge> edges, int vCount) {
		int[] rootArray = KruskalsAlgorithUsingDisjointSets.loadRoots(vCount);

		int mstWeight = 0;
		while (edges.size() > 0) {

			Edge e = edges.remove(); // Cross check
			if (e.a != e.b) {
				// avoid self loops
				int pa = KruskalsAlgorithUsingDisjointSets.getParent(e.a, rootArray);
				int pb = KruskalsAlgorithUsingDisjointSets.getParent(e.b, rootArray);
				if (pa != pb) {
					// both are not in same cluster
					mstWeight += e.w;
					KruskalsAlgorithUsingDisjointSets.unify(pa, pb, rootArray);
				}
			}
		}

		System.out.println(mstWeight);

	}

	private static void unify(int p1, int p2, int[] rootArray) {
		// Simple merge, for better result we can do path optimization
		rootArray[p1] = p2;
	}

	private static int getParent(int ele, int[] rootArray) {
		while (rootArray[ele] != ele) {
			ele = rootArray[ele];
		}
		return ele;
	}

	private static int[] loadRoots(int vCount) {
		int[] rootArray = new int[vCount + 1];
		for (int i = 0; i < vCount + 1; i++) {
			rootArray[i] = i;
		}
		return rootArray;
	}
}
