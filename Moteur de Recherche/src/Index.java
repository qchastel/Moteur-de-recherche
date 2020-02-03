import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Index {

	private Set<Document> listeDocument;
	private TreeSet<String> index;
	
	public Index() {
		this.listeDocument = new HashSet<>();
		this.index = new TreeSet<>();
	}

	
	private void ajouterNVTermes() {
		// TODO Auto-generated method stub
		
	}


	private void normalisation() {
		// TODO Auto-generated method stub
		
	}


	private void filtrage() {
		// TODO Auto-generated method stub
		
	}


	private void recuperationTexte() {
		
		
	}


	public Set<Document> getDoc() {
		return listeDocument;
	}
	
	
	public void ajouterDoc(Document d) {
		listeDocument.add(d);
		recuperationTexte(); //TODO
		filtrage(); //TODO
		normalisation(); //TODO
		ajouterNVTermes(); //TODO
	}
	
	
	public void replacageDoc(Document d){
		listeDocument.remove(d);
	}
	
	
	public Document chercherDoc(String chemin) {
		for (Document document : listeDocument) {
		if(document.getChemin().equals(chemin))
			return document;
		}
		return null;
	}
	
}
