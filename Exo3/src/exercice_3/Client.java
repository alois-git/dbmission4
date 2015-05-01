package exercice_3;

public class Client {
	private long id;
	private double amountDue;
	
	public Client(long id, double amountDue) {
		super();
		this.id = id;
		this.amountDue = amountDue;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
}
