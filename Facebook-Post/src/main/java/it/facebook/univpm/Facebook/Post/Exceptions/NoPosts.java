package it.facebook.univpm.Facebook.Post.Exceptions;

/*	ECCEZIONE PER ASSENZA DI POST
 * 	@author Matteo Sonaglioni
 * 	@author Lorenzo Toscanelli
 */
public class NoPosts extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoPosts() {
		super();
	}

	public NoPosts(String msg) {
		super(msg);
	}
}
