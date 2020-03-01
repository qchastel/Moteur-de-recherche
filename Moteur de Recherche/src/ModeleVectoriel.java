import java.util.HashSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class ModeleVectoriel {
	
	private boolean fTfidf = false;
	protected Doc[] fDocuments = null;
	
	protected ModeleVectoriel() {
		throw new UnsupportedOperationException( );
	}
	
	protected ModeleVectoriel(Doc[] documents) {
        throw new UnsupportedOperationException();
    }
	
	public static void setTfIdfWeight(Doc document, String term, Doc[] documents ) {
        double tf = document.calculMaxFreq() == 0 ? 0.0 : ( double ) document.calculFreq(term) / document.calculMaxFreq();
        if ( Double.isNaN( tf ) ) {
            tf = 0.0;
        }
        int n = 0;
        for ( Doc doc : documents ) {
            if (doc.calculFreq(term) > 0 ) {
                n++;
            }
        }
        double idf = Math.log( ( double ) documents.length / n ) / Math.log( 2 );
        if(Double.isNaN(idf)) {
            idf = 0.0;
        }
        document.setPoidsVecteur(term,tf*idf);
    }
	
	public ModeleVectoriel(Doc[] documents,boolean tfidf) {
        fTfidf = tfidf;
        fDocuments = documents;
        if ( fTfidf ) {
            for (Doc document : fDocuments ) {
                for (String term : document.getTermes() ) {
                    setTfIdfWeight( document, term, documents );
                }
            }
        }
    }
	
	public double sim(Doc document, Doc req) {
        Set<String> termes = new HashSet<String>();
        for (String terme : document.getTermes()) {
            termes.add(terme);
        }
        for (String terme : req.getTermes()) {
            termes.add(terme);
        }
        double numerator = 0.0;
        double denominator1 = 0.0;
        double denominator2 = 0.0;
        for ( String term : termes) {
            if (fTfidf) {
                numerator += document.getPoidsVecteur( term ) * req.getPoidsVecteur( term );
                denominator1 += document.getPoidsVecteur( term ) * document.getPoidsVecteur( term );
                denominator2 += req.getPoidsVecteur( term ) * req.getPoidsVecteur( term );
            } else {
                numerator += document.calculFreq( term ) * req.calculFreq( term );
                denominator1 += document.calculFreq( term ) * document.calculFreq( term );
                denominator2 += req.calculFreq( term ) * req.calculFreq( term );
            }
        }
        if ( denominator1 == 0 || denominator2 == 0 ) {
            return 0;
        }
        return numerator / ( Math.sqrt( denominator1 ) * Math.sqrt( denominator2 ) );
    }
	
	public SortedMap<Doc,Double> getDocuments(String queryString, boolean stem) {
        
        Doc query = new Doc("query",queryString);
        if (fTfidf) {
            Doc[] documents = new Doc[fDocuments.length + 1];
            System.arraycopy( fDocuments, 0, documents, 0, fDocuments.length );
            documents[documents.length - 1] = query;
            for ( String term : query.getTermes( ) ) {
                setTfIdfWeight(query,term,documents );
            }
        }
        Map<Doc,Double> map = new HashMap<Doc,Double>( );
        SortedMap<Doc,Double> result = new TreeMap<Doc,Double>( new ValueComparator(map));
        
        for (Doc document : fDocuments ) {
            map.put( document, sim(document,query));
        }
        result.putAll(map);
        return result;
    }


}
