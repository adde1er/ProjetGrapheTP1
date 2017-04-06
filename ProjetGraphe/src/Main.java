
public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Graphe a = new Graphe();
		Graphe g = a.RandomGraphe(5,10);
		DijkstraV1 d = new DijkstraV1(1, g);
		PlusCourtChemin p = new PlusCourtChemin(1, 5);
		p.affichePCC(d, 1, 5);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		/*dijkstra v2 : faire systeme de comparaion entre noeud
			remplir binary heap
			classer
			remove heap à chaque changement de noeuds
			reclasser ce qu'il reste
		*/
			
	}

}
