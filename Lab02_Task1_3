package Baitap;

public class PascalTriangle {
	public static void printPascalTriangle(int row) {
		for (int i = 0; i < row; i++) {
			int number = 1;
			System.out.format("%" + (row - i) * 2 + "s", "");
			for (int j = 0; j <= i; j++) {
				System.out.format("%4d", number);
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}

	public static int[] getPascalTriangle(int n) {
		int[] result = new int[n];
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = (int) ((result[i - 1] * (long) (n - i)) / i);
		}
		return result;
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[prevRow.length] = 1;
		for (int i = 1; i < prevRow.length; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		System.out.println("in tam giac Pascal voi 5 hang :");
		PascalTriangle.printPascalTriangle(5);
		System.out.println("cac gia tri hang thu 5 cua tam giac Pascal la:");
		int[] result = PascalTriangle.getPascalTriangle(5);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
			int[] prevRow = { 1, 3, 3, 1 };
			
		}
	}
}
