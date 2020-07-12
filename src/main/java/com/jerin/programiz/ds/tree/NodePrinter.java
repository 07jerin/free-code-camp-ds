package com.jerin.programiz.ds.tree;

import com.jerin.common.structures.ds.Node;

//TODO : Implement graphical print versions
public class NodePrinter<T> {

	public static void print(Node node) {
		if (node == null) {
			return;
		}
		while (node.getLeftNode() != null) {
			print(node.getLeftNode());
		}
	}

	private class Printer {
		private static final String TAB = "		";
		protected int count = 0;
		protected String value;

		public Printer(int count, String value) {
			this.count = count;
			this.value = value;
		}

	}

}
