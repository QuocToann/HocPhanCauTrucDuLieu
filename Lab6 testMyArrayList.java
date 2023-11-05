package BaiTap;

import java.util.Arrays;

public class test {
	
		public static void main(String[] args) {
			MyArrayList<Integer> list = new MyArrayList<>();
			for (int i = 0; i < 3; i++) {
				list.add(i);
				System.out.println(list.getSize());
			}

			MyArrayList<Integer> list1 = new MyArrayList<>();
			System.out.println(list1.isEmpty());
	
			MyArrayList<Integer> list3 = new MyArrayList<>();
			list.clear();
			System.out.println(Arrays.toString(list.toArray()));
		}	
}
