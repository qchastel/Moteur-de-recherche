import java.io.IOException;

public class Lancement {
	
	public static void main(String[] args) throws IOException {
		Crawler c = new Crawler();
		
		String chemin = "src/ressources/NYT20000531.0316";
		
		Doc d = new Doc(chemin,c.parcoursTermes(chemin));
		
		//ModeleBooleen mD= new ModeleBooleen();
	 
	    // Créer un tableau de même taille que le nombre d'objet de ArrayList
	    String tab[] = new String[d.getTermes().size()];
	 
	    // Transformer Le ArrayList en Tableau
	    tab = d.getTermes().toArray(tab);
	}

}
