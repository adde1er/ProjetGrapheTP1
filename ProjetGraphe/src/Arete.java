import java.util.Comparator;

public class Arete implements Comparator<Arete>{
	Point premier;
	Point second;
	double poids; //Ce n'est pas une femme, on a le droit de demander

	public Arete(Point p, Point s){
		premier = p;
		second = s;
		poids = p.distance(s);
	}

	public Point getPremier() {
		return premier;
	}

	public Point getSecond() {
		return second;
	}

	public double getPoids(){
		return poids;
	}

	@Override
	public int compare(Arete a1, Arete a2) {
		if(a1.getPoids() < a2.getPoids())
			return -1;
		else if(a1.getPoids() > a2.getPoids())
			return 1;
		else
			return 0;
	}



}
