import java.io.File;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;

public class Crawler {
	
	public static void main(String[] args) throws SAXException, IOException {
		//Récupération de tout les fichiers composant le moteur de recherche.
		ArrayList<String> listeFichiers = parcoursFichiers("/home/etudiants/info/ecoatelant/S4/RechercheDoc/corpusRInew",new ArrayList<>()); //Pour Emilie : "/home/etudiants/info/ecoatelant/S4/RechercheDoc/corpusRI"
		
		//Création de l'index ey remplissage de ce dernier.
		Index index = new Index();
		for(String chemin:listeFichiers) {
			index.ajouterDoc(new Document(chemin));
		}
		
		
		IndexInversé indexInv = new IndexInversé();
		
	}

	//Cette méthode retourne une liste avec les chemins des fichiers.
	public static ArrayList<String> parcoursFichiers(String cheminMoteurRecherche,ArrayList<String> listeChemins) {
		
	    File cheminCourant = new File(cheminMoteurRecherche);
	    String liste[] = cheminCourant.list();
	    if (liste != null) {         
	    	for (int i = 0; i < liste.length; i++) {
	    		File fichierCourant = new File(liste[i]);
	    		if(!fichierCourant.isFile()) {
	    			parcoursFichiers(cheminCourant+"/"+fichierCourant,listeChemins);
	    		}
	        }
	    }else{
	    	listeChemins.add(cheminCourant.toString());
	    }
	    return listeChemins;
	}

}
