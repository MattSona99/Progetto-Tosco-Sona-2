package it.facebook.univpm.Facebook.Post.Model;

import java.util.Vector;

/* QUESTA CLASSE GENERA LE STATISTICHE DI UN VECTOR
 * RIGUARDANTI LE LUNGHEZZE E LA PRESENZA DI HASHTAG
 * O TESTO ESCLUSIVAMENTE IN MAIUSCOLO
 * @author Lorenzo Toscanelli
 * 
 */
public class Stats {
	
	private StatLunghezze StatLunghezze;
	private StatHashMaiusc StatHashMaiusc;
	
	
	/* COSTRUTTORE DI STATS
	 * @param Vector v
	 */
	public Stats(Vector<Info> v) {
		if(v.size()!=0) {
			this.StatHashMaiusc = new StatHashMaiusc(v);
			this.StatLunghezze = new StatLunghezze(v);
		}
		else return;
	}
	
	public StatHashMaiusc getStatHashMaiusc() {
		return StatHashMaiusc;
	}

	public void setStatHashMaiusc(StatHashMaiusc statHashMaiusc) {
		StatHashMaiusc = statHashMaiusc;
	}
	
	public StatLunghezze getStatLunghezze() {
		return StatLunghezze;
	}

	public void setStatLunghezze(StatLunghezze statLunghezze) {
		StatLunghezze = statLunghezze;
	}
	
}
