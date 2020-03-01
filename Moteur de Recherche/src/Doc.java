import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Doc{

	private String chemin;
	private ArrayList<String> termes;
	private String numero,delai,date,headLine,titre,texte;
	private Map<String,Double> poidsVecteur = null;

	public Doc(String c,String corps) {
		this.chemin = c;
		this.termes=texteEnMap(corps);
		
	}

	//GETTER/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getChemin() {
		return chemin;
	}

	public ArrayList<String> getTermes() {
		return termes;
	}
	
	
	//Calcule la fréquence maximum d'un terme dans le document.
	public int calculMaxFreq() {
		//Construction d'une Map avec les mots et leurs fréquences.
		Map<String,Integer> motFreq= new HashMap<>();
		for(String mot:this.termes) {
			if(!(motFreq.containsKey(mot))) {
				motFreq.put(mot, 0);
			}else {
				motFreq.replace(mot, motFreq.get(mot)+1);
			}
		}
		int maxFreq = 0;
		for(int freq:motFreq.values()) {
			if(freq>maxFreq) {
				maxFreq=freq;
			}
		}
		return maxFreq;
	}
	
	//Calcule la fréquence d'un terme dans le document.
	public int calculFreq(String terme) {
		int freq = 0;
		for(String mot:this.termes) {
			if(mot==terme) {
				freq++;
			}
		}
		return freq;
	}
	
	public void setPoidsVecteur(String terme, double poids) {
        if (poidsVecteur == null ) {
        	poidsVecteur = new HashMap<String,Double>( );
        }
        poidsVecteur.put(terme,poids);
    }
	
	public Double getPoidsVecteur( String term ) {
        if ( term != null && poidsVecteur != null && poidsVecteur.containsKey( term ) ) {
            return poidsVecteur.get( term );
        }
        return 0.0;
    }

	//METHODES///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<String> texteEnMap(String texte) {
		ArrayList<String> listeMots = new ArrayList<String>();
		listeMots.addAll(Arrays.asList(texte.split(" ")));
		return listeMots;
	}

}
