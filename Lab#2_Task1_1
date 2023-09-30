package Baitap;

public class Task1_1 {
	public static int getSn1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(-1, i + 1) * i;
        }
        return sum;
    }
	
	 public static int getSn2(int n) {
	        int sum = 0;
	        int fact = 1;
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	            sum += fact;
	        }
	        return sum;
	    }
	 public static int getSn3(int n) {
	        int sum = 0;
	        for (int i = 1; i <= n; i++) {
	            sum += i * i;
	        }
	        return sum;
	    }
	   public static double getSn4(int n) {
	        double sum = 0.0;
	        double fact = 1.0;
	        for (int i = 1; i <= n; i++) {
	            fact *= (2.0 * i);
	            sum += 1.0 / fact;
	        }
	        return sum + 1;
	    }
	
	
		public static void main(String[] args) {
			int i = 5;
			System.out.println(getSn1(i));
			System.out.println(getSn2(i));
			System.out.println(getSn3(i));
			System.out.println(getSn4(i));
		}
}


