package com.jerin.common.structures.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*  g[]: adj list of the graph
*  N : number of vertices
*/

public class BFSMSimpleAdjecencyList {

	static ArrayList<Integer> bfsIteration(ArrayList<ArrayList<Integer>> g, int N) {

		ArrayList<Integer> bfs = new ArrayList<>(N);
		int[] visited = new int[N];
		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		visited[0] = 1;
		while (!q.isEmpty()) {
			int nextNode = q.poll();
			bfs.add(nextNode);
			for (Integer n : g.get(nextNode)) {
				if (visited[n] == 0) {
					visited[n] = 1;
					q.add(n);
				}
			}
		}

		return bfs;
	}

	/**
	 * Following is the recursive equivalent
	 * 
	 * @param g
	 * @param N
	 * @return
	 */
	static ArrayList<Integer> bfsRecursion(ArrayList<ArrayList<Integer>> g, int N) {
		ArrayList<Integer> bfs = new ArrayList<>(N);
		int[] visited = new int[N];
		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		visited[0] = 1;

		return BFSMSimpleAdjecencyList.rec(bfs, g, visited, q);

	}

	private static ArrayList<Integer> rec(ArrayList<Integer> bfs, ArrayList<ArrayList<Integer>> g, int[] visited,
			Queue<Integer> q) {
		if (q.isEmpty()) {
			return bfs;
		}

		int nextNode = q.poll();
		bfs.add(nextNode);
		for (Integer n : g.get(nextNode)) {
			if (visited[n] == 0) {
				visited[n] = 1;
				q.add(n);
			}
		}

		return BFSMSimpleAdjecencyList.rec(bfs, g, visited, q);

	}

}
