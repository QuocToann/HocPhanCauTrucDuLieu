package Baitap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {

	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<>();
		for (E e : array) {
			stack.push(e);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	// This method checks the correctness of the
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>
	// false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.pop();
				if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an
	// expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operations = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					num = num * 10 + (expression.charAt(i) - '0');
					i++;
				}
				i--;
				numbers.push(num);
			} else if (c == '(') {
				operations.push(c);
			} else if (c == ')') {
				while (operations.peek() != '(') {
					numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
				}
				operations.pop();
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!operations.isEmpty() && hasPrecedence(c, operations.peek())) {
					numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
				}
				operations.push(c);
			}
		}
		while (!operations.isEmpty()) {
			numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
		}
		return numbers.pop();
	}

	private static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		}
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return false;
		}
		return true;
	}

	private static int applyOperation(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}

	// method stutter that accepts a queue of integers as
	// a parameter and replaces
	// every element of the queue with two copies of that
	// element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int originalSize = input.size();
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll();
			input.add(element);
			input.add(element);
		}
	}

	// Method mirror that accepts a queue of strings as a
	// parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back // becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		int originalSize = input.size();
		Stack<E> stack = new Stack<>();
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll();
			input.add(element);
			stack.push(element);
		}
		while (!stack.isEmpty()) {
			input.add(stack.pop());
		}
	}

	public static void main(String[] args) {
		// Test reserve method
		Integer[] array = { 1, 2, 3, 4, 5 };
		MyLIFO_App.reserve(array);
		System.out.println("Reserve method result: " + Arrays.toString(array));

		// Test isCorrect method
		String input = "()(){}[]";
		boolean isCorrect = MyLIFO_App.isCorrect(input);
		System.out.println("IsCorrect method result: " + isCorrect);

		// Test stutter method
		Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3));
		MyLIFO_App.stutter(queue);
		System.out.println("Stutter method result: " + queue);

		// Test mirror method
		Queue<String> queue2 = new LinkedList<>(Arrays.asList("a", "b", "c"));
		MyLIFO_App.mirror(queue2);
		System.out.println("Mirror method result: " + queue2);
	}
}
