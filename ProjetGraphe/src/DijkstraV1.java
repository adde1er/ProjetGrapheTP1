import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DijkstraV1 {

	private HashMap<Integer, PlusCourtChemin> chemins;
	private Graphe graphe;

	public DijkstraV1(int idDepart, Graphe graphe){
		this.graphe = graphe;
		chemins = new HashMap<Integer, PlusCourtChemin>();
		process(init(idDepart));
	}

	private Noeud init(int idDepart){
		Iterator<Noeud> it = graphe.getNoeudsIt();
		int id;
		Noeud noeud;
		Noeud depart = null;
		while(it.hasNext()){
			noeud = it.next();
			id = noeud.getId();
			chemins.put(id,new PlusCourtChemin(id, idDepart));
			if(id == idDepart){
				depart = noeud;
			}
		}
		LinkedList<Arc> successeurs = depart.getSuccesseurs();
		Arc arc;
		chemins.get(depart.getId()).setCout(0);
		for(int i = 0; i<successeurs.size(); i++){
			arc = successeurs.get(i);
			chemins.get(arc.getFin()).setCout(arc.getPoids());
		}

		return depart;
	}

	private void process(Noeud depart){
		int id = depart.getId();
		LinkedList<Arc> successeurs = depart.getSuccesseurs();
		Arc next;
		Arc arc;
		boolean end = false;
		while (!end){
			chemins.get(id).setMarque(true);
			for(int i = 0; i< successeurs.size(); i++){
				arc = successeurs.get(i);
				//TODO
			}
		}
	}
}
