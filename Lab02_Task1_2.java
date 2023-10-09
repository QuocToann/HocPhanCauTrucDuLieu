package Baitap;

public class Fibonacci {
	public static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 0;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

	public static void printFibonacci(int n) {
		int fib = 0;
		int prevFib = 1;

		for (int i = 0; i < n; i++) {
			System.out.print(fib + " ");
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
		}
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("so Fibonacci thu 10 la: " + getFibonacci(n));
		System.out.println("10 so dau tien cua day Fibonacci la : ");
		printFibonacci(n);

	}
}

