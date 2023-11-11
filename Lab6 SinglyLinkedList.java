public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false
	// otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in
	// the list.
	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	// Returns (but does not remove) the last element in
	// the list.
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;

	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		return null;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		System.out.println(list.isEmpty());

		list.addFirst(1);
		System.out.println( list.first());
		System.out.println( list.last());

		list.addLast(2);
		System.out.println( list.first());
		System.out.println( list.last());

	}
}

