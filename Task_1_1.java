package Baitap;

import java.util.Arrays;

public class Task_1_1 {
	public static int[][] add(int[][] a, int[][] b) {
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] result = new int[rows][cols];
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] + b[i][j];
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
	    int[][] a = {{7, 2}, {5, 3}};
	    int[][] b = {{2, 1}, {3, 1}};
	    int[][] result = add(a, b);
	    System.out.println(Arrays.deepToString(result));
	}
}
