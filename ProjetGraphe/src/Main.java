import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		/*TSP tsp = new TSP(4);

		LinkedList<Arete> arbre = tsp.arbreKruskal();

		tsp.afficherArbre(arbre);*/
		Graphe a = new Graphe("graph1.csv");
		DijkstraV1 d = new DijkstraV1(1, a);
		PlusCourtChemin p = new PlusCourtChemin(1, 1);
		p.affichePCC(d, 1, 2);
		//a.visualiser();
	}

}
