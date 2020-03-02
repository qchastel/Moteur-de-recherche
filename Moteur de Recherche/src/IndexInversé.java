
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class IndexInversé {
	
	//Exemple de format : Mot -> liste de documents oÃ¹ le mot apparaÃ®t
	public HashMap<String,HashMap<Doc,Integer>> registreMots;
	
	public IndexInversé(){
		registreMots = new HashMap<String,HashMap<Doc,Integer>>() ;
	}
	
	public void indexation(ArrayList<String> motDuTexte, Doc d){
		//Pour chaque mot d'un texte donnÃ©, on regarde si ce mot est dÃ©jÃ  indexÃ©.
		for(String mot : motDuTexte) {
			//Si non alors on crÃ©Ã© un nouveau mot dans registreMots
			//avec un nouveau TreeSet qui contiendra tout les textes oÃ¹ apparaÃ®tront ce mÃªme mot et sa frÃ©quence initialisÃ© Ã  1.
			if(!registreMots.containsKey(mot)) {
				HashMap<Doc,Integer> listeDoc = new HashMap<>() ;
				listeDoc.put(d, 1);
				registreMots.put(mot,listeDoc);
			}
			//Si oui alors on trouve le mot et on regarde si dans la liste de documents, le document actuel est prÃ©sent.
			//Si non alors on ajoute 1 Ã  la frÃ©quence, si non alors il raoute le document Ã  la liste et initialise sa frÃ©quence Ã  1.
			else {
				
				HashMap<Doc, Integer> listeDocsMotCourant = registreMots.get(mot);
					if(listeDocsMotCourant.containsKey(d)) {
						listeDocsMotCourant.replace(d, listeDocsMotCourant.get(d)+1);
					}else {
						listeDocsMotCourant.put(d, 1);
					}
				}
			}
	}
	
	
	 public HashMap<String, HashMap<Doc, Integer>> getIndexInverse() {
		return registreMots;
	}
	 
	 public HashMap<Doc, Integer> listDoc(String s){
		 return registreMots.get(s);
	 }
	

}
