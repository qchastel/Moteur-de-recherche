import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<Doc> {
    
    Map<Doc,Double> fBase;
    
    public ValueComparator( Map<Doc,Double> base ) {
        fBase = base;
    }
    
    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare( Doc a, Doc b ) {
        if ( fBase.get( a ) >= fBase.get( b ) ) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}