
public class Arc {
	private int depart;
	private int fin;
	private double poids;

	public Arc(int depart, int fin, double poids) {
		this.depart = depart;
		this.fin = fin;
		this.poids = poids;
	}

	public int getDepart() {
		return depart;
	}

	public void setDepart(int depart) {
		this.depart = depart;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	@Override
	public String toString(){
		return depart + " -(" + poids + ")-> " + fin;
	}

}
