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

<<<<<<< HEAD
	
	private void ajouterNVTermes() {
		// TODO Auto-generated method stub
		
	}

	private void filtrage() {
		// TODO Auto-generated method stub
		
	}


	private void recuperationTexte() {
		
		
	}


=======
>>>>>>> 9e4a1629f06f92cffec62a5c5d5b17c412617995
	public Set<Doc> getListeDoc() {
		return listeDocument;
	}
	
	
	public void ajouterDoc(Doc d) {
		listeDocument.add(d);
<<<<<<< HEAD
		recuperationTexte(); //TODO
		filtrage(); //TODO
		//normalisation(); //TODO
		ajouterNVTermes(); //TODO
=======
>>>>>>> 9e4a1629f06f92cffec62a5c5d5b17c412617995
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
