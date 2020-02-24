
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class IndexInversé {
	
	//Exemple de format : Mot -> liste de documents où le mot apparaît
	public HashMap<String,TreeSet<HashMap<String,Integer>>> registreMots;
	
	public IndexInversé(){
		registreMots = new HashMap<String,TreeSet<HashMap<String,Integer>>>() ;
	}
	
	public void indexation(ArrayList<String> motDuTexte, String nomDoc){
		//Pour chaque mot d'un texte donné, on regarde si ce mot est déjà indexé.
		for(String mot : motDuTexte) {
			//Si non alors on créé un nouveau mot dans registreMots
			//avec un nouveau TreeSet qui contiendra tout les textes où apparaîtront ce même mot et sa fréquence initialisé à 1.
			if(!registreMots.containsKey(mot)) {
				TreeSet<HashMap<String,Integer>> listeDoc = new TreeSet<>();
				HashMap<String,Integer> motEtFrequence = new HashMap<>();
				motEtFrequence.put(nomDoc, 1);
				listeDoc.add(motEtFrequence);
				registreMots.put(mot,listeDoc);
			}
			//Si oui alors on trouve le mot et on regarde si dans la liste de documents, le document actuel est présent.
			//Si oui alors on ajoute 1 à la fréquence, si non alors il raoute le document à la liste et initialise sa fréquence à 1.
			else {
				TreeSet<HashMap<String,Integer>> listeDocsMotCourant = registreMots.get(mot);
				for(HashMap<String,Integer> mF : listeDocsMotCourant) { //TODO : remplacer par WHILE
					if(mF.containsKey(nomDoc)) {
						/*HashMap<String,Integer> pivot = mF;
						pivot.replace(nomDoc, mF.get(nomDoc)+1);
						listeDocsMotCourant.remove(mF);
						listeDocsMotCourant.add(pivot);*/
						mF.replace(nomDoc, mF.get(nomDoc)+1);
						registreMots.replace(mot,listeDocsMotCourant);
					}else {
						HashMap<String,Integer> mFNVMot = new HashMap<> ();
						mFNVMot.put(nomDoc, 1);
						listeDocsMotCourant.add(mFNVMot);
						registreMots.replace(mot,listeDocsMotCourant);
					}
				}
			}
		}
		
	}
	 public HashMap<String,TreeSet<HashMap<String,Integer>>> getIndexInverse() {
		return registreMots;
	}
	

}
