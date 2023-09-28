package Baitap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class MyArray {
	 private int[] array;

	    public MyArray(int[] array) {
	        this.array = array;
	    }

//task1.1:
		public static int[] mirror(int[] arr) {
			int[] res = new int[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				res[i] = arr[i];
				res[res.length - 1 - i] = arr[i];
			}

			return res;
		}
	    public int[] removeDuplicates() {
	        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
	        for (int i : array) {
	            set.add(i);
	        }
	        int[] newArray = new int[set.size()];
	        int index = 0;
	        for (Integer i : set) {
	            newArray[index++] = i;
	        }

	        return newArray;
	    }
//Task 1.2:	    
	    public int[] getMissingValues() {
	        int min = Arrays.stream(array).min().getAsInt();
	        int max = Arrays.stream(array).max().getAsInt();

	        List<Integer> missingValues = new ArrayList<>();
	        for (int i = min; i <= max; i++) {
	            if (!contains(i)) {
	                missingValues.add(i);
	            }
	        }

	        return missingValues.stream().mapToInt(i -> i).toArray();
	    }

	    private boolean contains(int value) {
	        for (int i : array) {
	            if (i == value) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    
		public static void main(String[] args) {
// task1.1:
			int[] arr = { 1, 2, 3 };
			System.out.println("-Mang tra ve cua [ 1, 2, 3 ] la :" + Arrays.toString(mirror(arr)));
			System.out.println("-Loai bo cac phan tu giong cua mang [1, 3, 5, 1, 3, 7, 9, 8] ta duoc :");
			int[] array2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
			MyArray myArray2 = new MyArray(array2);
			int[] newArray = myArray2.removeDuplicates();
			for (int i : newArray) {
				System.out.print(i + " ");
			}
			System.out.println();
//task1.2: 
			System.out.println("-Cac phan tu bi thieu cua chuoi [10, 11, 12, 13, 14, 16, 17, 19, 20] : ");
			int[] array1 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
			MyArray myArray1 = new MyArray(array1);
			int[] missingValues = myArray1.getMissingValues();
			for (int i : missingValues) {
				System.out.print(i + " ");
			}
		}}

