import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DijkstraV2 {

	public HashMap<Integer, PlusCourtChemin> chemins;
	public Graphe graphe;
	public BinaryHeap bh;

	public DijkstraV2(int idDepart, Graphe graphe){
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
			bh.add(noeud);
			chemins.put(id,new PlusCourtChemin(id, idDepart));
			if(id == idDepart){
				depart = noeud;
			}
		}
		LinkedList<Arc> successeurs = depart.getSuccesseurs();
		Arc arc;
		chemins.get(depart.getId()).setCout(0);
		chemins.get(depart.getId()).setMarque(true);
		for(int i = 0; i<successeurs.size(); i++){
			arc = successeurs.get(i);
			chemins.get(arc.getFin()).setCout(arc.getPoids());
		}
		return depart;
	}

	private void process(Noeud depart){
		ArrayList<Noeud> liste = graphe.getListeNoeud();
		liste.toString();
		int id = depart.getId();
		LinkedList<Arc> successeurs = depart.getSuccesseurs();
		Arc arc;
		int next = id;
		double min; 
		for (int i = 0; i < chemins.size(); i++) {
			min = Double.MAX_VALUE -1;
			chemins.get(id).setMarque(true);
			successeurs = liste.get(id-1).getSuccesseurs();
			for(int j = 0; j< successeurs.size(); j++){
				arc = successeurs.get(j);
				if (chemins.get(arc.getFin()).getCout() > chemins.get(arc.getDepart()).getCout()+arc.getPoids()){
					chemins.get(arc.getFin()).setParent(id);
					chemins.get(arc.getFin()).setCout(chemins.get(arc.getDepart()).getCout()+arc.getPoids());
				}
			}
			for (Arc a : successeurs) {
				if(chemins.get(a.getFin()).isMarque() == false){
					if(chemins.get(a.getFin()).getCout()<= min){
						min = chemins.get(a.getFin()).getCout();
					}
				}
				
			}
			
			for (Arc a : successeurs) {
				if(chemins.get(a.getFin()).getCout() == min){
					next = a.getFin();
					break;
				}
			}
			id = next;
		}
	}
}
