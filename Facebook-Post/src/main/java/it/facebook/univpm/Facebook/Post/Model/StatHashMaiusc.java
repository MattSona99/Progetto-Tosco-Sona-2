package it.facebook.univpm.Facebook.Post.Model;


import java.util.Vector;
import it.facebook.univpm.Facebook.Post.Util.Controlli;

/*	QUESTA CLASSE CONTROLLA CHE IN OGNI POST SALVATO IN v CI SIANO
 *	HASHTAG O SE IL MESSAGGIO E' ESCLUSIVAMENTE IN MAIUSCOLO, SETTANDOLI
 * 	@author Matteo Sonaglioni
 */
public class StatHashMaiusc {
	
	private int PwM=0;
	private int PwH=0;
	
	public StatHashMaiusc(Vector<Info> v) {
		
		if(v.size()!=0) {
			for(int i=0;i<v.size();i++) {
				v.elementAt(i).setMaiusc(Maiuscolo(v.elementAt(i).getMessage()));
				if(v.elementAt(i).isMaiusc()) this.PwM++;
				v.elementAt(i).setHashtag(Hashtag(v.elementAt(i).getMessage()));
				if(v.elementAt(i).isHashtag()) this.PwH++;
			}	
		}
	}
	
	/*	QUESTO METODO CONTROLLA CHE NELL'INFORMAZIONE IL TESTO SIA
	 * 	ESCLUSIVAMENTE IN MAIUSCOLO, SFRUTTANDO I METODI DEL PACKAGE UTIL.CONTROLLI
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
	
	public int getPwM() {
		return PwM;
	}

	public void setPwM(int PwM) {
		this.PwM = PwM;
	}

	public int getPwH() {
		return PwH;
	}

	public void setPwH(int PwH) {
		this.PwH = PwH;
	}

	public boolean Maiuscolo(String S) {
		if(Controlli.Maiusc(S)) return true;
		return false;
	}
	
	/*	QUESTO METODO CONTROLLA SE NEL MESSAGGIO DELL'INFORMAZIONE
	 * 	SONO PRESENTI HASHTAG, SFRUTTANDO I METODI DEL PACKAGE UTIL.CONTROLLI
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
	
	public boolean Hashtag(String S) {
		if(Controlli.Hashtag(S)) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Statistiche Hashtags & Post in Maiuscolo [Quantità di post in maiuscolo:" + PwM + ", Quantità di hashtags:" + PwH + "]";
	}
}
