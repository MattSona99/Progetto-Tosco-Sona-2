package it.facebook.univpm.Facebook.Post.Util;

/*	QUESTA CLASSE CONTIENE TRE OPERAZIONI PER
 * 	CALCOLARE IL MASSIMO, IL MINIMO E LA MEDIA
 * 	DI CARATTERI DI UN VECTOR
 *
 * 	@author Lorenzo Toscanelli
 */

import java.util.Vector;
import it.facebook.univpm.Facebook.Post.Model.*;
public class Lunghezze {
	
	/*	QUESTO METODO CALCOLA IL MESSAGGIO PIU'
	 * 	CORTO TRA TUTTI I POST
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
		
	public static int minimo(Vector<Info> v) {
		int min= v.elementAt(0).getLength();
		for(int i=0;i<v.size();i++) {
			if(v.elementAt(i).getLength()<min) {
				min=v.elementAt(i).getLength();
			}
		}
		return min;
	}
	
	/*	QUESTO METODO CALCOLA IL MESSAGGIO PIU'
	 * 	LUNGO TRA TUTTI I POST
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
	
	public static int massimo(Vector<Info> v) {
		int max= v.elementAt(0).getLength();
		for(int i=0;i<v.size();i++) {
			if(v.elementAt(i).getLength()>max) {
				max=v.elementAt(i).getLength();
			}
		}
		return max;
	}
	
	/*	QUESTO METODO CALCOLA LA MEDIA DI CHAR
	 * 	DI TUTTI I MESSAGGI DEI POST
	 * 	@param v		Vettore contenente le informazioni dei post
	 */
	
	public static int media(Vector<Info> v) {
		int media=0;
		for(int i=0;i<v.size();i++) {
			media+=v.elementAt(i).getLength();
			}
		media = media/v.size();
		return media;
	}
	
	
}
