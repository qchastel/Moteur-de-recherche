import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class Document extends DefaultHandler{

	private String chemin;
	private HashMap<String,Frequences> termes;
	private String numero,dateLine,dateTime,headLine,header,text;
	
	public Document(String c) {
		this.chemin = c;
		this.termes = new HashMap<>();
		//TODO recupererDonnees();
	}

	//GETTER/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getChemin() {
		return chemin;
	}

	public HashMap<String, Frequences> getTermes() {
		return termes;
	}
	
	//METHODES///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void recupererDonnees(int typeDonnee) {
		
		String donneeDemandee =  null;
		
		try{
			//Obtenir la configuration du SAX Parser
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			//Obtenir une instance de l'objet parser
			SAXParser saxParser = spfactory.newSAXParser();
			
	        DefaultHandler handler = new DefaultHandler() {
	        	boolean bNum = false;
	        	boolean bDateLine = false;
	        	boolean bDateTime = false;
	        	boolean bHeadLine = false;
	        	boolean bHeader = false;
	        	boolean bText = false;
	        	
	     
	            //Cette méthode est invoquée à chaque fois que le parser rencontre
	            //une balise ouvrante '<'
	            public void startElement(String uri, String localName,
	                   String qName,Attributes attributes) throws SAXException{
	     
	               if (qName.equalsIgnoreCase("DOCNO")) {
	                 bNum = true;
	               }
	     
	               if (qName.equalsIgnoreCase("DATELINE")) {
	            	   bDateLine = true;
	               }
	     
	               if (qName.equalsIgnoreCase("DATETIME")) {
	            	   bDateTime = true;
	               }
	     
	               if (qName.equalsIgnoreCase("HEADLINE")) {
	            	   bHeadLine = true;
	               }
	               
	               if (qName.equalsIgnoreCase("HEADER")) {
	            	   bHeader = true;
	               }
	               
	               if (qName.equalsIgnoreCase("P") || qName.equalsIgnoreCase("TEXT")) {
	            	   bText = true;
		           }
	               
	            }
	     
	            //Cette méthode est invoquée à chaque fois que parser rencontre
	            // une balise fermante '>'
	            public void endElement(String uri, String localName,
	                     String qName) throws SAXException {
	                    
	            	if (qName.equalsIgnoreCase("DOCNO")) {
	            		bNum = false;
		            }
		     
		            if (qName.equalsIgnoreCase("DATELINE")) {
		            	   bDateLine = false;
		            }
		     
		            if (qName.equalsIgnoreCase("DATETIME")) {
		            	   bDateTime = false;
		            }
		     
		            if (qName.equalsIgnoreCase("HEADLINE")) {
		            	   bHeadLine = false;
		            }
		               
		            if (qName.equalsIgnoreCase("HEADER")) {
		            	   bHeader = false;
		            }
		               
		            if (qName.equalsIgnoreCase("P") || qName.equalsIgnoreCase("TEXT")) {
		            	 bText = false;
			        }

	            }

	            //Cette méthode garde les données entre '<' et '>'
	            public void characters(char ch[], int start,
	                                  int length) throws SAXException {
	            	
	               if (bNum && typeDonnee == 1) {
	            	   System.out.println("Numéro : " + 
	            			   new String(ch, start, length));
	                 bNum = false;	            	   
	               }
	       
	               if (bDateLine && typeDonnee == 2) {
	                 System.out.println("Délai : " +
	                         new String(ch, start, length));
	                 bDateLine = false;
	               }
	     
	               if (bDateTime && typeDonnee == 3) {
	                 System.out.println("Date : " + 
	                         new String(ch, start, length));
	                 bDateTime = false;
	               }
	     
	               if (bHeadLine && typeDonnee == 4) {
	                 System.out.println("Titre : " + 
	                         new String(ch, start, length));
	                 bHeadLine = false;
	               }
	               
	               if (bHeader && typeDonnee == 5) {
		                 System.out.println("Header : " + 
		                         new String(ch, start, length));
		                 bHeader = false;
		           }
		     
		           if (bText && typeDonnee == 6) {
		                 System.out.println("Texte : " + 
		                         new String(ch, start, length));
		                 bText = false;
		           }
	               
	            }
	     
	         };
	     
	         saxParser.parse(this.chemin, handler);
	     
	         } catch (Exception e) {
	           e.printStackTrace();
	         }
	}
	
}
