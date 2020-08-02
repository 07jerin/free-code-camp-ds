package com.jerin.common.structures.ds.graph.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Given 2 integers N and M. N represents the number of vertices in the graph. M
 * represents the number of edges between any 2 vertices. Then M lines follow,
 * each line has 3 space separated integers a,b ,w where a and b represents an
 * edge from a vertex to a vertex and w respresents the weight of that edge.
 * 
 * @author jerijose
 *
 */

public class KruskalaAlgorithm {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		int vCount = Integer.parseInt(arr[0]);
		int eCount = Integer.parseInt(arr[1]);

		LinkedList<Edge> edges = new LinkedList<>();
		while (eCount > 0) {
			arr = sc.nextLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			edges.add(new KruskalaAlgorithm.Edge(a, b, w));
			eCount--;
		}
		
		Collections.sort(edges);
		LinkedList<Edge> copy1 = (LinkedList<Edge>) edges.clone();
		LinkedList<Edge> copy2 = (LinkedList<Edge>) edges.clone();

		long time = System.currentTimeMillis();
		KrsukalsAlgoUsingMap.usingMaps(copy1);
		System.out.println("Time taken for map : " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		KruskalsAlgorithUsingDisjointSets.usingDisjointSets(copy2, vCount);
		System.out.println("Time taken for disjomint set : " + (System.currentTimeMillis() - time));
	}
	
	


	static class Edge implements Comparable<Edge> {
		public int a;
		public int b;
		public int w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		public int compareTo(Edge other) {
			return this.w - other.w;
		}

	}
}
