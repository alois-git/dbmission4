package exercice_3;

import java.util.Date;
import java.util.*;

public class Order {
	private Client client;
	private long id;
	private Date date;

	public Order(){
		this.date = new Date();
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



}
