import java.util.ArrayList;

public class TraitementTexte {
	
	public ArrayList<String> traiterTexte(String texte) {
		return  Lemmatisation(NonMotsVide(Normalise(RecupTermes(texte))));
	}
	
	
	public ArrayList<String> RecupTermes(String texte){
		
		
		return null;
	} 
	
	public ArrayList<String> Normalise(ArrayList<String> termes){
		
		NonMotsVide(termes);
		Lemmatisation(termes);
		
		return termes;
	}
	
	public ArrayList<String> NonMotsVide(ArrayList<String> termes){
		
		
		
		return termes;
	}
	
	public ArrayList<String> Lemmatisation (ArrayList<String> termes){
		
		return termes;
	}
}
