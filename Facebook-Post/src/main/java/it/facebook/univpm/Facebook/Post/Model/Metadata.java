package it.facebook.univpm.Facebook.Post.Model;

/*	QUESTA CLASSE CONTIENE LE INFORMAZIONI GENERALI (METADATA) E LE RESTITUISCE
 * 	@author Matteo Sonaglioni
 * 	@author Lorenzo Toscanelli
 */

public class Metadata {
	private String nome;
	private String descrizione;
	private String tipo;
	
	/*	COSTRUTTORE DI METADATA, DOVE VIENE SALVATO IL NOME, 
	 * 	LA DESCRIZIONE ED IL TIPO DELL'INFORMAZIONE
	 *  @param nome				String che contiene l'id dell'informazione
	 *  @param descrizione		String che contiene la descrizione dell'informazione
	 *  @param tipo				String che contiene il tipo della variabile dell'informazione
	 */
	
	public Metadata(String nome, String descrizione, String tipo) {
		this.nome=nome;
		this.descrizione=descrizione;
		this.tipo=tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
