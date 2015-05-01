package exercice_3;

public class Drink {
	private long id;
	private double price;
	private String name;
	private String description;

	public Drink(){

	}

	public Drink(long id, double price, String name, String description) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
