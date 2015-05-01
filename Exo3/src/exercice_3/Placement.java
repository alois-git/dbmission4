package exercice_3;
import java.io.Serializable;

public class Placement implements Serializable{
	private Table table;
	private Client client;
	private long id;

	public Placement(){
		
	}

	public Placement(Table table, Client client) {
		super();
		this.table = table;
		this.client = client;
	}

	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


}
