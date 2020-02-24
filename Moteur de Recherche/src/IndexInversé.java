
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class IndexInversé {
	
	public HashMap<String,TreeSet<String>> indexInverse;
	
	public IndexInversé() {
		
		indexInverse = new HashMap<String,TreeSet<String>>() ;
	}
	
	public void indexé(ArrayList<String> texte, String nomDoc){
		
		for(String s :texte) {
			if(!indexInverse.containsKey(s)) {
				TreeSet<String> a = new TreeSet<>();
				a.add(nomDoc);
				indexInverse.put(s,a);
			}
			else {
				TreeSet<String> a = indexInverse.get(s);
				a.add(nomDoc);
				indexInverse.replace(s,a);
			}
		}
	}
	 public HashMap<String, TreeSet<String>> getIndexInverse() {
		return indexInverse;
	}
	

}
