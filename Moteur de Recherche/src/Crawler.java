import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Crawler {
	
	public static void main(String[] args) {
		parcoursFichiers("/home/etudiants/info/ecoatelant/S4/RechercheDoc/corpusRI/D0821D");
	}
	
	Index index = new Index();
	IndexInversé indexInv = new IndexInversé();
	//sax sortir xml
	
	public static void parcoursFichiers(String cheminMoteurRecherche) {
		
		Set<String> listeChemins = new HashSet<>();
		
	    File repertoire = new File(cheminMoteurRecherche);	//Pour Emilie : "/home/etudiants/info/ecoatelant/S4/RechercheDoc/"
	    String liste[] = repertoire.list();
	    if (liste != null) {         
	    	for (int i = 0; i < liste.length; i++) {
	    		File fichierCourant = new File(liste[i]);
	    		System.out.println(fichierCourant.toString());
	    		System.out.println(liste[i].isFile());
	    		if(!liste[i].is) {
	    			parcoursFichiers(repertoire+fichierCourant.toString());
	    		} else if (fichierCourant.isFile()){
	    			listeChemins.add(fichierCourant.list()[0]);	
	    			System.out.println(fichierCourant);
	    		}
	        }
	    } else {
	   	//System.err.println("Nom de repertoire invalide");
	    }
	}

}
