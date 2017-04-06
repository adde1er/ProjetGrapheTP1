import java.util.ArrayList;

public class PlusCourtChemin {
	private int id;
	private double cout;
	private int parent;
	private boolean marque;

	public PlusCourtChemin(int id, int idDepart){
		this.id = id;
		cout = Double.MAX_VALUE;
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
	
	public void affichePCC(DijkstraV1 d, int start, int finish){
		double a = d.chemins.get(finish).getCout();
		int idf = finish;
		ArrayList<Integer> chemin = new ArrayList<Integer>();
		for (int i = 0; i < d.chemins.size(); i++) {
			if (finish != start && d.chemins.get(finish).getCout()!= Integer.MAX_VALUE){
				chemin.add(d.chemins.get(finish).getId());
				finish = d.chemins.get(finish).getParent();
			}	
		}
		if (chemin.isEmpty() || a==Double.MAX_VALUE){
			System.out.println("Il n'existe pas de chemin depuis le noeud " + start + " vers "+ idf);
		}else{
			chemin.add(start);
			for (int i = 1; i < chemin.size(); i++) {
				System.out.println(chemin.get(chemin.size()-i) + " --> " + chemin.get(chemin.size()-i-1));
			}
			System.out.println("Le cout est de :"+ a);
		}
		
	}


}
