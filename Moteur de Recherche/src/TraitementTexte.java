import java.util.ArrayList;

public class TraitementTexte {
	
	private ArrayList<String> motvide;
	
	public TraitementTexte() {
	
	motvide=new ArrayList<>();
	motvide.add("Je");
	motvide.add("un");
	motvide.add("qui");
	motvide.add("de");
	motvide.add("ou");
	motvide.add("pas");
	}
	
	
	public ArrayList<String> RecupTermes(String texte){
		ArrayList<String> termes =new ArrayList<>();
		String[]t=texte.split(" ");
		for (String string : t) {
			termes.add(string.trim());
		}
		return termes;
		
	} 
	
	public ArrayList<String> Normalise(ArrayList<String> termes){

		Lemmatisation(termes);
		NonMotsVide(termes);
		
		return termes;
	}
	
	private ArrayList<String> NonMotsVide(ArrayList<String> termes){
		
		for (String string : motvide) {
			for (int i=0;i<termes.size();i++) {
				if(string.equals(termes.get(i))) {
					termes.remove(termes.get(i));
					i=termes.size();
				}
			}
		}
		
		return termes;
	}
	
	private ArrayList<String> Lemmatisation (ArrayList<String> termes){
		
		
		return termes;
	}
}
