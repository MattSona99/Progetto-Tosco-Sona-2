package it.facebook.univpm.Facebook.Post.Filters;
import it.facebook.univpm.Facebook.Post.Model.Info;
import java.util.Vector;

/* FILTRO PER POST SOLO CON HASHTAG
 * @author Lorenzo Toscanelli
 */
public class FiltriHashtag {
	private String tipo;
	
	public FiltriHashtag(String tipo) {
		this.tipo=tipo;
	}
	
	public Vector<Info> filtered(Vector<Info> v) {
		Vector<Info> p = new Vector<Info>();
		if(tipo=="checkhashtag") {
			for(int i=0;i<v.size();i++) {
				if(v.elementAt(i).isHashtag()){
					Info info = new Info(v.elementAt(i).getMessage());
					p.add(info);
				}	
			}
		}
		return p;
	}
}
