package Baitap;

public class Task_1_4 {
	public static int[][] transpose(int[][] a) {
	    int m = a.length;
	    int n = a[0].length;

	    int[][] b = new int[n][m];

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            b[j][i] = a[i][j];
	        }
	    }

	    return b;
	}
	public static void main(String[] args) {
	    int[][] original = {
	        {1, 2, 3, 4},
	        {4, 5, 6,7},
	        {7, 8, 9,9 }
	    };

	    int[][] transposed = transpose(original);

	    System.out.println("matran luc dau:");
	    printMatrix(original);

	    System.out.println("matran sau thay doi:");
	    printMatrix(transposed);
	}

	public static void printMatrix(int[][] matrix) {
	    for (int[] row : matrix) {
	        for (int element : row) {
	            System.out.print(element + " ");
	        }
	        System.out.println();
	    }
	
	}
}
