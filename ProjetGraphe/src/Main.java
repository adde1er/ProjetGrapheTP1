import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		TSP tsp = new TSP(4);

		LinkedList<Arete> arbre = tsp.arbreKruskal();

		tsp.afficherArbre(arbre);
	}

}
