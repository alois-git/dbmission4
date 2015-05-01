package exercice_3;

public class Table {
	private long id;
	private long codebar;
	private boolean isFree;

        public Table(){
        }
	
	public Table(long id, long codebar, boolean isFree) {
		super();
		this.id = id;
		this.codebar = codebar;
		this.isFree = isFree;
	}
	
	public Table(long id) {
		super();
		this.id = id;
		this.codebar = id;
		this.isFree = true;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCodebar() {
		return codebar;
	}
	public void setCodebar(long codebar) {
		this.codebar = codebar;
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
}
