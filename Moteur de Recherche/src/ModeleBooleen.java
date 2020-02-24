import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class ModeleBooleen {
	
	public String requete;
	public TraitementTexte tT;
	public Crawler crawler;
	
	/*public ModeleBooleen(String mots,String expressionExacte,String auMoins,String pasCeMot) {
		this.requete = transformationEnReq(mots,expressionExacte,auMoins,pasCeMot);
	}*/
	
	public String transformationEnReq(String expressionExacte,String mots,String auMoins,String pasCeMot) {
		ArrayList<String> nvExpressionExacte = new ArrayList<>();
		nvExpressionExacte = tT.traiterTexte(expressionExacte);
		if(nvExpressionExacte!=null) {
			
			return expressionExacte;
		}else {
			
			return mots+"^AND^"+auMoins+"^OR^"+auMoins+"^NOT^"+pasCeMot;
		}
	}
	
	/*public void requete(String arguments){
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
		
	}*/
	
	public HashSet<String> recherche(String requete){
	
		HashMap<HashMap<String,String>,Integer> incidenceTermeDocument = new HashMap<>();
		
		String[] decoupage,decoupageAND,decoupageOR,decoupageNOT;
		boolean booleenDecoupage,booleenDecoupageAND,booleenDecoupageOR,booleenDecoupageNOT;
		decoupageNOT = requete.split("^NOT^");
		if(decoupageNOT.length > 1)
			booleenDecoupageNOT=true;
		else
			booleenDecoupageNOT=false;
		decoupageOR = requete.split("^OR^");
		if(decoupageOR.length > 1)
			booleenDecoupageOR=true;
		else
			booleenDecoupageOR=false;
		decoupageAND = requete.split("^AND^");
		if(decoupageOR.length > 1)
			booleenDecoupageAND=true;
		else
			booleenDecoupageAND=false;
		
		ArrayList<String> decoupageArray = new ArrayList<>();
		
		decoupage = requete.split("^AND^","^OR^","^NOT^");
		for (int i = 0; i < decoupage.length; i++) {
			decoupageArray.add(decoupage[i]);
		}
		
		
	}
	

}