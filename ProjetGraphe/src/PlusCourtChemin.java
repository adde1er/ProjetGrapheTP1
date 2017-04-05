
public class PlusCourtChemin {
	private int id;
	private double cout;
	private int parent;
	private boolean marque;

	public PlusCourtChemin(int id, int idDepart){
		this.id = id;
		cout = -1;
		parent = idDepart;
		marque = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public boolean isMarque() {
		return marque;
	}

	public void setMarque(boolean marque) {
		this.marque = marque;
	}


}
