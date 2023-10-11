package Task2;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("01", "Pen", 5.0, "Pen");
		Product p2 = new Product("02", "Ruler", 10.0, "Ruler");
		Product p3 = new Product("03", "Book", 15.0, "Book");

		OrderItem o1 = new OrderItem(p1, 3);
		OrderItem o2 = new OrderItem(p2, 3);
		OrderItem o3 = new OrderItem(p3, 4);

		OrderItem[] listItems = new OrderItem[] { o1, o2, o3, };

		Order order = new Order(listItems);

		System.out.print("Test Cost: ");
		System.out.println(order.cost());

		System.out.print("Test Contain: ");
		System.out.println(order.contains(p1));

		System.out.println("Test Filter");
		System.out.println(Arrays.toString(order.filter("Book")));

	}

}
