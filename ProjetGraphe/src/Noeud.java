import java.util.LinkedList;

public class Noeud {
	private int id;
	private LinkedList<Arc> successeurs;

	public Noeud(int id) {
		this.id = id;
		this.successeurs = new LinkedList<Arc>();
	}

	public void ajouterArc(Arc arc) {
		if(arc.getDepart() != id) return;

		for(int i = 0 ; i < successeurs.size() ; i++) {
			if(successeurs.get(i).getFin() == arc.getFin()) return;
		}
		successeurs.add(arc);
	}

	public void supprimerArc(Arc arc) {
		for(int i = 0 ; i < successeurs.size() ; i++) {
			if(successeurs.get(i).getFin() == arc.getFin()) successeurs.remove(i);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Arc> getSuccesseurs(){
		return successeurs;
	}

}
