import java.util.ArrayList;

public class TraitementTexte {
	
	private ArrayList<String> motvide;
	
	public TraitementTexte() {
	
	motvide=new ArrayList<>();
	String s ="a,about,above,after,again,against,all,am,an,and,any,are,aren't,as,at,be,because,been,before,being,below,between,both,but,by,can't,cannot,could,couldn't,did,didn't,do,does,doesn't,doing,don't,down,during,each,few,for,from,further,had,hadn't,has,hasn't,have,haven't,having,he,he'd,he'll,he's,her,here,here's,hers,herself,him,himself,his,how,how's,i,i'd,i'll,i'm,i've,if,in,into,is,isn't,it,it's,its,itself,let's,me,more,most,mustn't,my,myself,no,nor,not,of,off,on,once,only,or,other,ought,our,ours,ourselves,out,over,own,same,shan't,she,she'd,she'll,she's,should,shouldn't,so,some,such,than,that,that's,the,their,theirs,them,themselves,then,there,there's,these,they,they'd,they'll,they're,they've,this,those,through,to,too,under,until,up,very,was,wasn't,we,we'd,we'll,we're,we've,were,weren't,what,what's,when,when's,where,where's,which,while,who,who's,whom,why,why's,with,won't,would,wouldn't,you,you'd,you'll,you're,you've,your,yours,yourself,yourselves";
	String[] tab=s.split(",");
	
     
      for(int i=0; i < tab.length; i++)
        motvide.add(tab[i]);
   }

	
	
	private static ArrayList<String> RecupTermes(String texte){
		ArrayList<String> termes =new ArrayList<>();
		String[]t=texte.split(" ");
		for (String string : t) {
			termes.add(string.trim());
		}
		return termes;
		
	} 
	
	
	private ArrayList<String> NonMotsVide(ArrayList<String> termes){
		
		for (String string : motvide) {
			for (int i=0;i<termes.size();i++) {
				if(string.equals(termes.get(i))) {
					termes.remove(termes.get(i));
					i=termes.size();
				}
			}
		}
		
		return termes;
	}
	
	private ArrayList<String> Lemmatisation (ArrayList<String> termes){
		
		
		return termes;
	}
	
	public ArrayList<String> traiteTexte(String s){
		ArrayList<String> requete = RecupTermes(s) ;
		NonMotsVide(requete);
		Lemmatisation(requete);
		return requete;
		
	}
	
	
	//split("a,about,above,after,again,against,all,am,an,and,any,are,aren't,as,at,be,because,been,before,being,below,between,both,but,by,can't,cannot,could,couldn't,did,didn't,do,does,doesn't,doing,don't,down,during,each,few,for,from,further,had,hadn't,has,hasn't,have,haven't,having,he,he'd,he'll,he's,her,here,here's,hers,herself,him,himself,his,how,how's,i,i'd,i'll,i'm,i've,if,in,into,is,isn't,it,it's,its,itself,let's,me,more,most,mustn't,my,myself,no,nor,not,of,off,on,once,only,or,other,ought,our,ours,ourselves,out,over,own,same,shan't,she,she'd,she'll,she's,should,shouldn't,so,some,such,than,that,that's,the,their,theirs,them,themselves,then,there,there's,these,they,they'd,they'll,they're,they've,this,those,through,to,too,under,until,up,very,was,wasn't,we,we'd,we'll,we're,we've,were,weren't,what,what's,when,when's,where,where's,which,while,who,who's,whom,why,why's,with,won't,would,wouldn't,you,you'd,you'll,you're,you've,your,yours,yourself,yourselves")

}
