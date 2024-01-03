package lab11;

import java.util.Collection;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		root = addRecursive(root, e);
	}

	private BNode<E> addRecursive(BNode<E> current, E value) {
		if (current == null) {
			return new BNode<E>(value);
		}

		if (value.compareTo(current.value) < 0) {
			current.left = addRecursive(current.left, value);
		} else if (value.compareTo(current.value) > 0) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return containsRecursive(root, e);
	}

	private boolean containsRecursive(BNode<E> current, E value) {
		if (current == null) {
			return false;
		}
		if (value.compareTo(current.value) == 0) {
			return true;
		}
		return value.compareTo(current.value) < 0 ? containsRecursive(current.left, value)
				: containsRecursive(current.right, value);
	}

	// Find the minimum element in BST
	public E findMin() {
		return findMinRecursive(root);
	}

	private E findMinRecursive(BNode<E> current) {
		return current.left == null ? current.value : findMinRecursive(current.left);
	}

	// Find the maximum element in BST
	public E findMax() {
		return findMaxRecursive(root);
	}

	private E findMaxRecursive(BNode<E> current) {
		return current.right == null ? current.value : findMaxRecursive(current.right);
	}

	// Remove element e from BST
	public void remove(int value) {
		root = removeRecursive(root, value);
	}

	private Node removeRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Node to delete found
			// ... code to delete the node will go here
		}
		if (value < current.value) {
			current.left = removeRecursive(current.left, value);
			return current;
		}
		current.right = removeRecursive(current.right, value);
		return current;
	}

	// compute the depth of a node in BST
	public int depth() {
		return depth(root);
	}

	private int depth(Node node) {
		if (node == null) {
			return -1;
		} else {
			int leftDepth = depth(node.left);
			int rightDepth = depth(node.right);

			if (leftDepth > rightDepth) {
				return (leftDepth + 1);
			} else {
				return (rightDepth + 1);
			}
		}
	}
	// Compute total nodes in BST

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

}

