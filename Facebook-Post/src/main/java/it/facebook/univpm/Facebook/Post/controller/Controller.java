package it.facebook.univpm.Facebook.Post.controller;


import java.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.facebook.univpm.Facebook.Post.Exceptions.InvalidToken;
import it.facebook.univpm.Facebook.Post.Exceptions.NoPosts;
import it.facebook.univpm.Facebook.Post.Filters.FiltriHashtag;
import it.facebook.univpm.Facebook.Post.Filters.FiltriLunghezza;
import it.facebook.univpm.Facebook.Post.Model.Info;
import it.facebook.univpm.Facebook.Post.Model.Metadata;
import it.facebook.univpm.Facebook.Post.Model.Posts;
import it.facebook.univpm.Facebook.Post.Model.StatHashMaiusc;
import it.facebook.univpm.Facebook.Post.Model.StatLunghezze;
import it.facebook.univpm.Facebook.Post.Model.Stats;
/*	QUESTA CLASSE GESTISCE LE CHIAMATE DI GET E POST CON ROTTE DISTINTE
 * 	@author Matteo Sonaglioni
 * 	@author Lorenzo Toscanelli
 */
@RestController
public class Controller {
	
	private Posts post;
	private Stats stats;
	
	@Autowired
	private void costr() throws InvalidToken {
		post = new Posts();
		stats = new Stats(post.getPost());
	}
	
	/*	QUESTO METODO RISPONDE A GET /Metadata
	 * 	RESTITUENDO TUTTE LE INFORMAZIONI
	 * 	
	 */
	
	@GetMapping("/Metadata")
	public Metadata[] getMetadata() {
		return post.getMetadata();
	}
	
	/*	QUESTO METODO RISPONDE A GET /Data
	 * 	RESTITUENDO UN VECTOR DEI POST CON I RELATIVI DATI
	 * 	@return Vector di Info
	 */
	
	@GetMapping("/Data")
	public Vector<Info> post() {
		return post.getPost();
	}
	
	/*	QUESTO METODO RISPONDE A GET /Stats
	 * 	RESTITUENDO LE STATISTICHE GENERALI DEI POST
	 * 	@return Stats
	 */
	
	@GetMapping("/Stats")
	public Stats getStat() throws NoPosts{
		if(post.getPost().size()!= 0) return stats;
		throw new NoPosts ("Non ci sono posts.");
	}
	
	/*	QUESTO METODO RISPONDE A GET /Stats/Lunghezze
	 * 	RESTITUENDO LE STATISTICHE RIGUARDANTI LE LUNGHEZZE DEI POST
	 * 	@return StatLunghezze
	 */
	
	@GetMapping("/Stats/Lunghezze")
	public StatLunghezze getStatLength() throws NoPosts{
		if(post.getPost().size()!= 0) return stats.getStatLunghezze();
		throw new NoPosts("Non ci sono posts.");
	}
	
	/*	QUESTO METODO RISPONDE A POST /Filtri/Lunghezze
	 * 	RESTITUENDO UN VECTOR DI POST FILTRATI A SECONDA DELLA RICHIESTA
	 * 	@return Vector di Info
	 */
	
	@PostMapping("/Filtri/Lunghezze")
	public Vector<Info> getFiltLength(@RequestBody String body) {
		FiltriLunghezza f = new FiltriLunghezza(body);
		Vector<Info> v = f.filtered(post.getPost());
		return v;
	}
	
	/*	QUESTO METODO RISPONDE A GET /Stats/Others
	 * 	RESTITUENDO STATISTICHE SU PRESENZA DI HASHTAG O
	 * 	POST ESCLUSIVAMENTE IN MAIUSCOLO
	 * 	@return StatHashMaiusc
	 */
	
	@GetMapping("/Stats/Others")
	public StatHashMaiusc getStatHash() throws NoPosts{
		if(post.getPost().size()!= 0) return stats.getStatHashMaiusc();
		throw new NoPosts("Non ci sono posts.");
	}
	
	/*	QUESTO METODO RISPONDE A POST /Filtri/Hashtag
	 * 	RESTITUENDO UN VECTOR DEI POST CON HASHTAG
	 * 	@return Vector di Info
	 */
	
	@PostMapping("/Filtri/Hashtag")
	public Vector<Info> getFiltHashtag (@RequestBody String body) {
		FiltriHashtag f = new FiltriHashtag(body);
		Vector<Info> v = f.filtered(post.getPost());
		return v;
	}
	
}
