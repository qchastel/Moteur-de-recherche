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
		//TO-DO
	}
	
	

	
	
	
	
}
