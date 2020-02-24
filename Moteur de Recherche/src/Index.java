import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Index {

	private Set<Doc> listeDocument;
	private TreeSet<String> index;
	
	public Index() {
		this.listeDocument = new HashSet<>();
		this.index = new TreeSet<>();
	}

	
	private void ajouterNVTermes() {
		// TODO Auto-generated method stub
		
	}

	private void filtrage() {
		// TODO Auto-generated method stub
		
	}


	private void recuperationTexte() {
		
		
	}


	public Set<Doc> getListeDoc() {
		return listeDocument;
	}
	
	
	public void ajouterDoc(Doc d) {
		listeDocument.add(d);
		recuperationTexte(); //TODO
		filtrage(); //TODO
		//normalisation(); //TODO
		ajouterNVTermes(); //TODO
	}
	
	
	public void replacageDoc(Doc d){
		listeDocument.remove(d);
	}
	
	
	public Doc chercherDoc(String chemin) {
		for (Doc document : listeDocument) {
		if(document.getChemin().equals(chemin))
			return document;
		}
		return null;
	}
	
}
