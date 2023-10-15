package BaiTap;

import java.util.Arrays;

public class Task1_3 {
	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int currentElement = array[i];
			int j = i - 1;
			for (; j >= 0 && array[j] < currentElement; j--) {
              array[j +1 ] = array [j];   
			}
	array [j+1] = currentElement;
		}
	}
	
	public static void main(String[] args) {
		int myArray[] = { 11, 22, 33, 99, 88, 77 };
		insertionSort(myArray);
		System.out.println(Arrays.toString(myArray));
	}
}
