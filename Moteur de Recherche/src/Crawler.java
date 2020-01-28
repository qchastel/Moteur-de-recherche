import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Crawler {
	
	//sax sortir xml
	
	public static void main(String[] args) {
		
		Set<String> listeChemins = new HashSet<>();
		
		Index index = new Index();
		IndexInversé indexInv = new IndexInversé();
		
	    File repertoire = new File("/home/etudiants/info/ecoatelant/S4/RechercheDoc/");
	    String liste[] = repertoire.list();
	    for(int)
	    if (liste != null) {         
	    	for (int i = 0; i < liste.length; i++) {
	    		File f = new File(repertoire+liste[i]);
	    		if(!f.isFile()) {
	    			System.out.println(liste[i]);
	    		}
	        	//listeChemins.add(liste[i]);
	        }
	    } else {
	   	System.err.println("Nom de repertoire invalide");
	    }
	}

}
