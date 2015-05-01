package exercice_3;

public class OrderedDrink {
	private Drink drink;
	private long qty;
	
	public OrderedDrink(Drink drink, long qty) {
		super();
		this.drink = drink;
		this.qty = qty;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}
	
	
}
