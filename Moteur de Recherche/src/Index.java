import java.util.TreeSet;

public class Index {

	private TreeSet<Document> doc;
	
	public Index() {
		this.doc = new TreeSet<>();
	}

	public TreeSet<Document> getDoc() {
		return doc;
	}
	
	public void ajouterDoc(Document d) {
		doc.add(d);		
	}
	
	//Quentin me fait chier
	public void replacageDoc(Document d){
		doc.remove(doc.)
	}
	
	public Document chercherDoc(String chemin) {
		
	for (Document document : doc) {
		if(document.getChemin().equals(chemin))
			return document;
	}
		return null;
		
		
	}

	
	
	
	
}
