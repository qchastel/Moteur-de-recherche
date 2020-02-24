import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class ModeleBooleen {
	
	//public ArrayList<String> D;
	//public ArrayList<String> Q;
	//public ArrayList<String> F;
	public String requete;
	public Index index;
	public TraitementTexte tT;
	public Crawler crawler;
	public HashMap<String,TreeSet<HashMap<String,Integer>>> a = crawler.indexInv.getIndexInverse();
	
	public ModeleBooleen(String mots,String expressionExacte,String auMoins,String pasCeMot) {
		this.requete = transformationEnReq(mots,expressionExacte,auMoins,pasCeMot);
	}
	
	public String transformationEnReq(String mots,String expressionExacte,String auMoins,String pasCeMot) {
		if(expressionExacte==null) {
			return expressionExacte;
		}
		else {
			return mots+"^AND^"+auMoins+"^OR^"+auMoins+"^NOT^"+pasCeMot;
		}
	}
	
	public void requete(String arguments){
		ArrayList<String> motsTraites=tT.traiterTexte(arguments);
		ArrayList<String> docChemin = new ArrayList<>();
		
		for(String s : motsTraites) {
			docChemin.addAll(a.get(s));
		}
		
		HashMap<String,Integer> c = new HashMap<>();
		for(int i = 0; i< docChemin.size();i++) {
			c.put(docChemin.get(i), 0);
			docChemin.remove(0);
			for(int y=i;y<docChemin.size();y++) {
				if(docChemin.get(i).equals(docChemin.get(y))) {
					c.replace(docChemin.get(i), c.get(docChemin.get(i))+1);
					docChemin.remove(y);
				}
			}
		}
		
	}
	
	

}