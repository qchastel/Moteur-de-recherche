import java.util.HashMap;

public class Document {

	private String chemin;
	private HashMap<String,Frequences> termes;
	
	public String getChemin() {
		return chemin;
	}

	public HashMap<String, Frequences> getTermes() {
		return termes;
	}
	
	public Document(String chemin) {
		this.chemin = chemin;
		this.termes = new HashMap<>();
	}
	
	
	
}
