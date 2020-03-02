import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;

public class Lancement {
	
	public static void main(String[] args) throws IOException {
		Index index=new Index();
		IndexInversé indexI= new IndexInversé();
		TraitementTexte tTexte=new TraitementTexte();
		
		
		Crawler c = new Crawler(index,indexI,tTexte);
		
		String chemin = "src/ressources/NYT20000531.0316";
		
		Doc d = new Doc(chemin,c.parcoursTermes(chemin));
		
		//ModeleBooleen mD= new ModeleBooleen();
	 
	    // Creer un tableau de meme taille que le nombre d'objet de ArrayList
	   // String tab[] = new String[d.getTermes().size()];
	 
	    // Transformer le ArrayList en Tableau
	    //tab = d.getTermes().toArray(tab);
	    
		ModeleBooleen mb=new ModeleBooleen(new TraitementTexte(),new Index(),new IndexInversé());
		//mb.resultat("Soldier","iran americ" , "shadow");
		
		//Creation d'une requete pour le modele vectoriel
		ModeleVectoriel mv = new ModeleVectoriel();
		String req = "";
		//System.out.println(c.getListeDoc().get(0).getTermes());
		mv.fDocuments = new Doc[1];//[c.getListeDoc().size()];
		//mv.fDocuments = c.getListeDoc().toArray(mv.fDocuments);
		mv.fDocuments[0]=c.getListeDoc().get(0);
		SortedMap<Doc, Double> docReq = mv.getDocuments(req);
		for (Double doub : docReq.values()) {
			if(doub!=0)
				System.out.println(doub);
		}
		System.out.println(docReq.toString());
	}

}
