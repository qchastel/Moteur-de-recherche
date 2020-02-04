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

public class Doc{

	private String chemin;
	private HashMap<String,Frequences> termes;
	private String numero,delai,date,headLine,titre,texte;

	public Doc(String c,String corps) {
		this.chemin = c;
		texteEnMap(corps);
		this.termes = new HashMap<>();
		
	}

	//GETTER/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getChemin() {
		return chemin;
	}

	public HashMap<String, Frequences> getTermes() {
		return termes;
	}

	//METHODES///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//TODO
	public HashMap<String,Frequences> texteEnMap(String texte) {
		ArrayList<String> listeMots = new ArrayList<String>();
		listeMots.addAll(Arrays.asList(texte.split(" ")));
		System.out.println(listeMots.toString());
		System.out.println("fin");
		return null;
	}

}
