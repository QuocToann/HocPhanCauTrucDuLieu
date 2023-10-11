package Task2;

public class OrderItem implements Comparable<OrderItem> {
	Product p;
	int quality;

	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getPrice() {
		return p.getPrice();
	}

	public String getName() {
		return p.getName();
	}

	public String getId() {
		return p.getId();
	}

	@Override
	public int compareTo(OrderItem o) {

		return this.getP().compareTo(o.getP());
	}

	@Override
	public String toString() {
		return "" + this.getPrice() + this.getP().toString();
	}

	public int compareByType(OrderItem o2) {
		return this.getP().compareByType(o2.getP());
	}

}
