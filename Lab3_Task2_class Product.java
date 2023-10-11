package Task2;


public class Product implements Comparable<Product> {
	String id;
	String name;
	double price;
	String type;

	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	@Override
	public int compareTo(Product p) {
		return this.getId().compareTo(p.getId());
	}

	public int compareByType(Product p) {
		return this.getType().compareTo(p.getType());
	}

}
