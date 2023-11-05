package BaiTap;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
	}

// creates an array of double-size if the array of elements is full

	public void growSize() {
		if (size == elements.length) {
			E[] newElements = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
	}

	public int getSize() {
		return size;
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.

	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		E oldElement = elements[i];
		elements[i] = e;
		return oldElement;
	}

	// It is used to append the specified element at the end of a list.

	/*
	 * public boolean add(E e) { if (size == elements.length) { growSize(); }
	 * elements[size] = e; size++; return true; }
	 */

	// Inserts element e to be at index i, shifting all subsequent elements later.

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	// // Removes and returns the element at index i, shifting subsequent elements
	// earlier.

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}
		E oldElement = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return oldElement;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		this.elements = (E[]) new Object[elements.length];
		this.size = 0;
	}

	// It is used to return the index in this list of the
	// last occurrence of the specified element, or -1 if the
	// list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if ((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
				return i;
			}
		}
		return -1;
	}

	//// It is used to return an array containing all of the
	// elements in this list in the correct order
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(this.elements.length);
		for (int i = 0; i < size; i++) {
			clonedList.elements[i] = this.elements[i];
		}
		clonedList.size = this.size;
		return clonedList;
	}

	// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if ((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if ((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {

		return false;
	}

	// It is used to sort the elements of the list on the
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

}
