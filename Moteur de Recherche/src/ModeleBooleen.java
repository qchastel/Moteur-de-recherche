import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;

public class ModeleBooleen {
	
	//public ArrayList<String> D;
	//public ArrayList<String> Q;
	//public ArrayList<String> F;
	public String requete;
	public Index index;
	public TraitementTexte tT;
	
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
		tT.traiterTexte(arguments);
		
	}
	
	

}