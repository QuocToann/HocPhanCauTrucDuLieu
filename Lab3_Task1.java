package baitap;

public class MyArray {

	private int[] array;
	public MyArray(int[] array) {
		this.array = array;
	}
	//Task 1.1
	public static int iterativeLinearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}
	public int recursiveLinearSearch(int[] array, int target) {
	    return recursiveLinearSearchHelper(array, target, 0);
	}

	private int recursiveLinearSearchHelper(int[] array, int target, int index) {
		if (index >= array.length) {
			return -1;
		}
		if (array[index] == target) {
			return index;
		}
		return recursiveLinearSearchHelper(array, target, index + 1);
	}
	//Task 1.2
	public int iterativeBinarySearch(int[] array, int target) {
	    int left = 0;
	    int right = array.length - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (array[mid] == target) {
	            return mid;
	        } else if (array[mid] < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return -1;
	}
	public int recursiveBinarySearch(int[] array, int target) {
	    return recursiveBinarySearchHelper(array, target, 0, array.length - 1);
	}

	private int recursiveBinarySearchHelper(int[] array, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] < target) {
			return recursiveBinarySearchHelper(array, target, mid + 1, right);
		} else {
			return recursiveBinarySearchHelper(array, target, left, mid - 1);
		}
	}
	public static void main(String[] args) {
	    int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
	    int target = 45;
	    int index = iterativeLinearSearch(array, target);
	    if (index == -1) {
	        System.out.println("Không tìm thấy giá trị " + target + " trong mảng.");
	    } else {
	        System.out.println("Giá trị " + target + " được tìm thấy tại vị trí " + index + " trong mảng.");
	    }
	}
	
}
