import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Crawler {
	
	ArrayList<String> listeFichiers;
	Index index;
	IndexInversé indexInv;
	
	public Crawler(){
		//Récupération de tout les fichiers composant le moteur de recherche.
		//Pour Emilie - IUT :
		//this.listeFichiers = parcoursFichiers("/home/etudiants/info/qchastel/eclipse-workspace/corpusRInew",new ArrayList<>());
		//Pour Emilie - MAC :
		this.listeFichiers = parcoursFichiers("/Users/ecoatelant/Documents/eclipse-workspace/Moteur-de-recherche/corpusRInew",new ArrayList<>());
		
		//Initialisation de l'index, de l'index inversé et remplissage de ces derniers avec un traitement de texte créé.
		this.index = new Index();
		this.indexInv = new IndexInversé();
		TraitementTexte tT= new TraitementTexte();
		for(String chemin:listeFichiers) {
			String texteDoc = parcoursTermes(chemin);
			index.ajouterDoc(new Doc(chemin,texteDoc));
			indexInv.indexation(tT.traiteTexte(texteDoc), chemin);
		}
		
		
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
	
	public String parcoursTermes(String cheminFichier) {
		ArrayList<String> listeTermes = new ArrayList<>();
		try {
			File fichierCourant = new File(cheminFichier);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fichierCourant);
			doc.getDocumentElement().normalize();
			NodeList listeTitre = doc.getElementsByTagName("HEADLINE");
			NodeList listeMot = doc.getElementsByTagName("TEXT");
			
			String premierP = null;
            String corps = "";
            if(listeTitre.getLength() == 0) {
                listeTitre = doc.getElementsByTagName("HEADER");

                // au cas où pas de titre, on prends le premier paragraphe

                if(listeTitre.getLength() == 0) {
                    premierP = listeMot.item(0).getTextContent();
                }
            }
            
            for (int i = 0; i < listeMot.getLength(); i++) {
                Node nNode = listeMot.item(i);
                corps += nNode.getTextContent();
            }
            try {
                return corps;

            } catch (NullPointerException e) {
                return corps;

            }
			
		}catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
		}
		return null;
	}

	public ArrayList<String> getListeFichiers() {
		return listeFichiers;
	}

	public void setListeFichiers(ArrayList<String> listeFichiers) {
		this.listeFichiers = listeFichiers;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	public IndexInversé getIndexInv() {
		return indexInv;
	}

	public void setIndexInv(IndexInversé indexInv) {
		this.indexInv = indexInv;
	}
	
}
