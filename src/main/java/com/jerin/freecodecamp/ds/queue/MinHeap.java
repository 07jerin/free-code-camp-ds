package com.jerin.freecodecamp.ds.queue;

import com.jerin.common.structures.ds.Node;
import com.jerin.programiz.ds.tree.CompleteTree;

public class MinHeap<T extends Comparable<T>> extends CompleteTree<T> {

	public MinHeap(Node<T> root) {
		super(10);
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPresent(T t) {
		throw new Error("Not supported");
	}


	@Override
	public void insert(T data) {
		int insertedIndex = this.insertLast(data);
		if(insertedIndex == 0) {
			return;
		}
	}
	
	private void minHeapifyUp(T data,  int dataIndex) {
	}


}
