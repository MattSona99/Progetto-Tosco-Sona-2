package it.facebook.univpm.Facebook.Post.Model;
import it.facebook.univpm.Facebook.Post.Util.Lunghezze;

import java.util.Vector;

/*	QUESTA CLASSE CALCOLA MEDIA, MASSIMO E MINIMO DELLA LUNGHEZZA DI OGNI
 * 	POST CONTENUTO NEL VECTOR v
 * 	@author Matteo Sonaglioni
 */

public class StatLunghezze {
	private int max;
	private int min;
	private int media;
	
	/*	QUESTO METODO CALCOLA, ATTRAVERSO IL PACKAGE UTIL.LUNGHEZZE,
	 * 	IL MASSIMO, IL MINIMO E LA MEDIA DEI CARATTERI CONTENUTI NEI POST
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
	
	public StatLunghezze(Vector<Info> v) {
		this.min=Lunghezze.minimo(v);
		this.max=Lunghezze.massimo(v);
		this.media=Lunghezze.media(v);
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}
	
	@Override
	public String toString() {
		return "Statistiche Lunghezza [Lunghezza minima dei post=" + min + ", Lunghezza massima dei post=" + max + 
				", Lunghezza media dei post=" + media  + "]";
	}
}
