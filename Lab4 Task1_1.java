package BaiTap;

import java.util.Arrays;

public class Task1_1 {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int maxvalue = array[i];
			int maxindex = i;
			for (int j = i; j < array.length; j++) {
				if (maxvalue < array[j]) {
					maxvalue = array[j];
					maxindex = j;

				}
			}
			if (maxindex != i) {
				int temp = array[i];
				array[i] = maxvalue;
				array[maxindex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] myArray = { 3, 5, 7, 9, 11, 13 }; 
		selectionSort(myArray);
		System.out.println(Arrays.toString(myArray));

	}
}
