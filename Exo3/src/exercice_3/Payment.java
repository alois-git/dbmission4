package exercice_3;

public class Payment {
	private long id;
	private double amountPaid;

	public Payment(long id, double amountPaid) {
		super();
		this.id = id;
		this.amountPaid = amountPaid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


}
