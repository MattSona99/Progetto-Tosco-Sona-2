package it.facebook.univpm.Facebook.Post.Util;

/*	QUESTA CLASSE CONTIENE DUE OPERAZIONI UTILI PER
 * 	CONTROLLARE SE UNA STRINGA CONTIENE HASHTAGS O
 * 	SE LA STRINGA CONTIENE SOLAMENTE CARATTERI
 * 	MAIUSCOLI
 * 
 * 	@author Lorenzo Toscanelli
 * 
 */

public class Controlli {
	
	/*	QUESTO METODO RESTITUISCE TRUE SE LA STRINGA CONTIENE
	 * 	CARATTERI DI TIPO "#" (HASHTAG)
	 * 	@param s		String che contiene il messaggio dei post
	 */
	
	public static boolean Hashtag(String s) {
		String r="#";
		for(int i=0;i<s.length();i++) {
			if(s.contains(r)) return true;
		}
		return false;
	}
	
	/*	QUESTO METODO RESTITUISCE TRUE SE LA STRINGA CONTIENE
	 * 	SOLAMENTE CARATTERI MAIUSCOLI, IGNORANDO GLI SPAZI
	 * 	@param s		String che contiene il messaggio dei post
	 */
	
	public static boolean Maiusc(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ' && !Character.isUpperCase(s.charAt(i))) {
				return false;
			}
		}
		return true;	
	}
}
