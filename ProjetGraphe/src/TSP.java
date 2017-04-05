import java.util.ArrayList;
import java.util.LinkedList;

public class TSP {

	ArrayList<Point> points;
	ArrayList<Point> nonMarques;

	public TSP(int n) {
		points = new ArrayList<Point>();
		nonMarques = new ArrayList<Point>();

		for(int i = 0 ; i < n ; i++) {
			points.add(new Point(Math.random(), Math.random() , i));
		}

	}

	public LinkedList<Point> circuitAleatoire() {
		LinkedList<Point> circuit = new LinkedList<Point>();

		nonMarques = new ArrayList<Point>(points);

		int index;
		while(points.size() > circuit.size()) {
			index = (int) (Math.random() * nonMarques.size());
			circuit.add(nonMarques.get(index));
			nonMarques.remove(index);
		}

		return circuit;
	}

	public LinkedList<Point> circuitGlouton(){
		LinkedList<Point> circuit = new LinkedList<Point>();

		nonMarques = new ArrayList<Point>(points);

		int index = (int) (Math.random() * nonMarques.size());
		circuit.add(nonMarques.get(index));
		nonMarques.remove(index);

		double distance;
		double tmp;
		int toAdd;
		while(points.size() > circuit.size()) {
			distance = circuit.get(circuit.size() - 1).distance(nonMarques.get(0));
			toAdd = 0;
			for(int i = 1 ; i < nonMarques.size() ; i++) {
				tmp = circuit.get(circuit.size() - 1).distance(nonMarques.get(i));
				if (tmp < distance) {
					distance = tmp;
					toAdd = i;
				}
			}
			circuit.add(nonMarques.get(toAdd));
			nonMarques.remove(toAdd);
		}

		return circuit;
	}

	public LinkedList<Arete> arbreKruskal(){
		LinkedList<Arete> arbre = new LinkedList<Arete>();
		LinkedList<Arete> liste = new LinkedList<Arete>();
		LinkedList<LinkedList<Point>> connexe = new LinkedList<LinkedList<Point>>();

		for(int i = 0; i< points.size(); i++){ //on crée les arêtes
			for(int c = i+1; c<points.size();c++){
				liste.add(new Arete(points.get(i), points.get(c)));
			}
		}

		liste.sort(liste.get(0));
		arbre.add(liste.get(0));
		connexe.add(new LinkedList<Point>());
		connexe.get(0).add(arbre.get(0).getPremier());
		connexe.get(0).add(arbre.get(0).getSecond());

		LinkedList<Point> temp;
		boolean added;
		int index;
		for(int i = 1; i<liste.size(); i++){
			added = false;
			for(int j = 0; j<connexe.size(); j++){
				temp = connexe.get(j);
				if(temp.contains(liste.get(i).getPremier())){
					if(added == false){
						if(!(temp.contains(liste.get(i).getSecond()))){ //ça merde là

							System.out.println( liste.get(i).getPremier().getIndex() + "-(" + liste.get(i).getPoids() + ")-" + liste.get(i).getSecond().getIndex());

							temp.add(liste.get(i).getSecond());
							added = true;
							index = j;
							arbre.add(liste.get(i));
						}
					}
					else{
						temp.remove(liste.get(i).getPremier());
						temp.addAll(connexe.get(j));
						connexe.remove(j);
						j--;
					}
				}
				else if(temp.contains(liste.get(i).getSecond())){
					if(added == false){
						if(!(temp.contains(liste.get(i).getPremier()))){ //et là
							temp.add(liste.get(i).getPremier());
							added = true;
							index = j;
							arbre.add(liste.get(i));
						}
					}
					else{
						temp.remove(liste.get(i).getSecond());
						temp.addAll(connexe.get(j));
						connexe.remove(j);
						j--;
					}
				}
			}
			if(added == false){
				connexe.add(new LinkedList<Point>());
				connexe.get(connexe.size()-1).add(liste.get(i).getPremier());
				connexe.get(connexe.size()-1).add(liste.get(i).getSecond());
				arbre.add(liste.get(i));
			}
		}

		return arbre;
	}

	public void afficherArbre(LinkedList<Arete> a) {
		for(int i = 0 ; i < a.size() ; i++) {
			System.out.println(a.get(i).getPremier().getIndex() + "-(" + a.get(i).getPoids() + ")-" + a.get(i).getSecond().getIndex());
		}
	}

	public double longueurCircuit(LinkedList<Point> circuit) {
		double longueur = 0;

		for(int i = 0 ; i < circuit.size() -1; i++) {
			longueur += circuit.get(i).distance(circuit.get(i + 1));
		}

		longueur += circuit.get(circuit.size() -1).distance(circuit.get(0));

		return longueur;
	}

	public void afficherCircuit(LinkedList<Point> circuit) {
		for(int i = 0 ;  i < circuit.size() ; i++) {
			System.out.print(circuit.get(i).getIndex() + "-->");
		}

		System.out.println(circuit.get(0).getIndex());
	}
}
