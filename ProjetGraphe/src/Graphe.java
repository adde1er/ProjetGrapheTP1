import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Graphe {
	private HashMap<Integer, Noeud> noeuds;

	public Graphe() {
		this.noeuds = new HashMap<Integer, Noeud>();
	}

	public Graphe(String csv){
		this.noeuds = new HashMap<Integer, Noeud>();
		Iterable<CSVRecord> records;
		String depart, poids, fin;
		try {
			Reader in = new FileReader(csv);
			records = CSVFormat.RFC4180.withHeader("depart", "fin", "poids").parse(in);
			for (CSVRecord record : records) {
			    depart = record.get("depart");
			    fin = record.get("fin");
			    poids = record.get("poids");
			    ajouterArc(new Arc(Integer.parseInt(depart),Integer.parseInt(fin), Double.parseDouble(poids)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void ajouterNoeud(Noeud noeud) {
		int id = noeud.getId();
		if(!noeuds.containsKey(id)) {
			noeuds.put(id, noeud);
		}
	}

	public void ajouterArc(Arc arc){
		int depart = arc.getDepart();
		int fin = arc.getFin();
		if(!noeuds.containsKey(depart)) ajouterNoeud(new Noeud(depart));
		if(!noeuds.containsKey(fin)) ajouterNoeud(new Noeud(fin));

		noeuds.get(depart).ajouterArc(arc);
	}

	public void visualiser(){
		LinkedList<Arc> successeurs;
		Iterator<Noeud> it;
		it = getNoeudsIt();
		while(it.hasNext()){
			successeurs = it.next().getSuccesseurs();
			for(int i = 0; i<successeurs.size(); i++){
				System.out.println(successeurs.get(i));
			}
		}
	}

	public Iterator<Noeud> getNoeudsIt(){
		return noeuds.values().iterator();
	}

	public Noeud getNoeud(int id){
		return noeuds.get(id);
	}
	
	public ArrayList<Noeud> getListeNoeud(){
		ArrayList<Noeud> liste = new ArrayList<Noeud>();
		Iterator<Noeud> it = getNoeudsIt();
		while (it.hasNext()){
			liste.add(it.next());
		}
		return liste;
	}
	
	public Graphe RandomGraphe(int n, int p){
		Graphe g = new Graphe();
		for (int i = 0; i < n; i++) {
			g.ajouterNoeud(new Noeud(i+1));
		}
		Double d; 
		int s; 
		int f;
		for (int i = 0; i < p; i++) {
			d = Math.random()*(n+1);
			s = d.intValue()+1;
			d = Math.random()*(n+1);
			f = d.intValue()+1;
			g.ajouterArc(new Arc(s,f,Math.random()*25));
		}
		return g;
	}
}

