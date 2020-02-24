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

	public Set<Doc> getListeDoc() {
		return listeDocument;
	}
	
	
	public void ajouterDoc(Doc d) {
		listeDocument.add(d);
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
