package com.jerin.freecodecamp.ds.list;

public interface List<T> {

	public void add(T element);

	public void add(T element, int index) throws IndexOutOfBoundsException;

	public boolean remove(T element);

	public boolean remove(int index) throws IndexOutOfBoundsException;

	public int get(T element);

	public T get(int index);
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();

}
