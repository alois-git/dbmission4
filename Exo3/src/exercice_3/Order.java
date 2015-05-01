package exercice_3;

import java.sql.Date;
import java.util.List;

public class Order {
	private Client client;
	private long id;
	private Date date;
	private List<OrderedDrink> comand;
	
	public Order(Client client, long id, Date date, List<OrderedDrink> comand) {
		super();
		this.client = client;
		this.id = id;
		this.date = date;
		this.comand = comand;
	}
	public Order(Client client, long id, Date date) {
		super();
		this.client = client;
		this.id = id;
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<OrderedDrink> getComand() {
		return comand;
	}
	public void setComand(List<OrderedDrink> comand) {
		this.comand = comand;
	}
	public void addItem(OrderedDrink orderedDrink){
		comand.add(orderedDrink);
	}
	
	
	
}
