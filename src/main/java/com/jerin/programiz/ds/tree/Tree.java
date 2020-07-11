package com.jerin.programiz.ds.tree;

import java.util.List;

public interface Tree<T> {
	
	public abstract boolean isPresent(T t);

	public abstract void insert(T data);

	public abstract boolean delete(T data);
	
	public abstract List<T> inOrderTravesal();
	
	public abstract List<T> preOrderTravesal();
	
	public abstract List<T> postOrderTravesal();
	
	public abstract T minValue();
	
	public abstract T maxValue();
	
	public abstract int height();

}
