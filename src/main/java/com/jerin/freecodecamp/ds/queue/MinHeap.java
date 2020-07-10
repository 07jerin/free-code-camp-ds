package com.jerin.freecodecamp.ds.queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jerin.programiz.ds.tree.CompleteTree;

public class MinHeap<U extends Comparable<U>> extends CompleteTree<U> {

	private Map<U, Set<Integer>> indexMap = new HashMap<>();

	public MinHeap(int defaultSize) {
		super(defaultSize);
	}

	@Override
	public boolean isPresent(U t) {
		return indexMap.containsKey(t);
	}

	@Override
	public boolean delete(U data) {
		Set<Integer> indexSet = indexMap.get(data);
		if (indexSet == null) {
			return false;
		}

		int index = indexSet.stream().findFirst().get();
		swap(data, index, getLastElement(), getLastIndex());
		deleteLast();
		removeFromIndexMap(data, getLastIndex());

		U parent = index == 0 ? null : getParent(index);
		data = getIndexData(index);
		if (parent == null) {
			swimDown(data, index);
		} else if (parent.compareTo(data) > 0) {
			swimUp(data, index);
		} else {

		}

		return true;
	}

	private void swap(U data1, int index1, U data2, int index2) {
		swapInStorage(data1, index1, data2, index2);
		swapInIndexMap(data1, index1, data2, index2);
	}

	private void removeFromIndexMap(U data, int index) {
		Set<Integer> indexSet = indexMap.get(data);
		indexSet.remove(index);
		if (indexSet.isEmpty()) {
			indexMap.remove(data);
		}
	}

	public U poll() {
		U data = getRootValue();
		int lastIndex = getLastIndex();
		U lastElement = getLastElement();
		swap(data, 0, lastElement, lastIndex);
		deleteLast();
		removeFromIndexMap(data, lastIndex);
		swimDown(lastElement, 0); // Last element will be at 0, now swim down
		return data;

	}

	public U peek() {
		return getRootValue();
	}

	@Override
	public void insert(U data) {
		int insertedIndex = this.insertLast(data);
		addToMap(data, elementCount - 1);
		if (insertedIndex != 0) {
			swimUp(data, elementCount - 1);
		}

	}

	private void addToMap(U data, int index) {
		Set<Integer> indexSet = indexMap.get(data);
		if (indexSet == null) {
			indexSet = new HashSet<Integer>();
			indexMap.put(data, indexSet);
		}
		indexSet.add(index);
	}

	private void swapInIndexMap(U data1, int index1, U data2, int index2) {
		Set<Integer> indexSet1 = indexMap.get(data1);
		Set<Integer> indexSet2 = indexMap.get(data2);
		indexSet1.remove(index1);
		indexSet2.remove(index2);
		indexSet1.add(index2);
		indexSet2.add(index1);
	}

	private void swapInStorage(U data1, int index1, U data2, int index2) {
		this.storage[index2] = data1;
		this.storage[index1] = data2;
	}

	private void swimUp(U data, int dataIndex) {
		int parentIndex = this.getParentIndex(dataIndex);
		U parentData = getParent(dataIndex);
		while (parentData.compareTo(data) > 0) {
			swapInIndexMap(parentData, parentIndex, data, dataIndex);
			swapInStorage(parentData, parentIndex, data, dataIndex);
			dataIndex = parentIndex;
			if (dataIndex == 0) {
				break;
			}
			parentIndex = this.getParentIndex(dataIndex);
			parentData = getParent(dataIndex);
		}
	}

	private void swimDown(U data, int dataIndex) {
		U leftChildData = this.getLeftChild(dataIndex);
		U rightChildData = this.getRightChild(dataIndex);

		while (leftChildData != null) {
			U childData = rightChildData == null || leftChildData.compareTo(rightChildData) <= 0 ? leftChildData
					: rightChildData;
			int childIndex = rightChildData == null || leftChildData.compareTo(rightChildData) <= 0
					? getChildIndex(dataIndex, true)
					: getChildIndex(dataIndex, false);
			if (data.compareTo(childData) <= 0) {
				return;
			}
			swapInIndexMap(childData, childIndex, data, dataIndex);
			swapInStorage(childData, childIndex, data, dataIndex);

			dataIndex = childIndex;
			leftChildData = this.getLeftChild(dataIndex);
			rightChildData = this.getRightChild(dataIndex);

		}
	}

	@Override
	public U minValue() {
		return getRootValue();
	}

}
