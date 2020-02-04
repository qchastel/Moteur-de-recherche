
public class Lancement {
	
	public static void main(String[] args) {
		Crawler c = new Crawler();
		
		String chemin = "src/ressources/NYT20000531.0316";
		
		Doc d = new Doc(chemin,c.parcoursTermes(chemin));
	}

}
