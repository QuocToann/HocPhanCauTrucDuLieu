package BaiTap;

import java.util.Arrays;

public class Task1_2 {
	public static int[] bubbleSort(int[] myArray) {
		for (int i = 1; i < myArray.length; i++) {
			for (int j = 0; j < myArray.length - 1; j++) {
				if (myArray[j] < myArray[j + 1]) {
					int temp = myArray[j];
					myArray[j] = myArray[j + 1];
					myArray[j + 1] = temp;
				}
			}

		}

		return myArray;

	}

	public static void main(String[] args) {
		int myArray[] = { 33, 99, 133, 199, 66, 166 };
		bubbleSort(myArray);
		System.out.println(Arrays.toString(myArray));
	}
}
