package exercice_3;

public class Placement {
	private Table table;
	private Client client;
	
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
