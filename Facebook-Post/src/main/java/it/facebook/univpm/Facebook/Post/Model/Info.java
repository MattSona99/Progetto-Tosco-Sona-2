package it.facebook.univpm.Facebook.Post.Model;

/*	QUESTA CLASSE CONTIENE LE INFORMAZIONI CHE CI INTERESSANO DEI POST
*	@author Matteo Sonaglioni
*	@author Lorenzo Toscanelli
*/

public class Info {
	private String message;
	private int length;
	private boolean hashtag;
	private boolean maiusc;
	private boolean mention;
	
	/*	COSTRUTTORE DI INFO, DOVE SALVA IL MESSAGGIO E CALCOLA LA LUNGHEZZA DEL MESSAGGIO
	 *  @param message		Messaggio contenuto nel post (String)
	 *  @param length		Lunghezza del messaggio contenuto nel post (Integer)
	 */
	
	public Info(String message) {
		this.message=message;;
		this.length=this.message.length();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int lenght) {
		this.length = lenght;
	}

	public boolean isHashtag() {
		return hashtag;
	}

	public void setHashtag(boolean hashtag) {
		this.hashtag = hashtag;
	}

	public boolean isMaiusc() {
		return maiusc;
	}

	public void setMaiusc(boolean maiusc) {
		this.maiusc = maiusc;
	}

	public boolean isMention() {
		return mention;
	}

	public void setMention(boolean mention) {
		this.mention = mention;
	}
	
	@Override
	public String toString() {
		String s="Messaggio: " + this.message + "\nLunghezza: " + this.length + "\n";
		return s;
	}
	
}
