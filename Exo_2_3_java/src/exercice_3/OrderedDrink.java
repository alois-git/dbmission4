package exercice_3;
import java.io.Serializable;

public class OrderedDrink implements Serializable{
	private Order order;
	private Drink drink;
	private int qty;

	public OrderedDrink(){
		
	}

	public OrderedDrink(Order order,Drink drink, int qty) {
		super();
		this.drink = drink;
		this.qty = qty;
		this.order = order;
	}

	public Order getOrder(){
		return order;
	}

	public void setOrder(Order o){
		this.order = o;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


}
