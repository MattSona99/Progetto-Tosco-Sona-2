package it.facebook.univpm.Facebook.Post;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import it.facebook.univpm.Facebook.Post.Model.Info;
import it.facebook.univpm.Facebook.Post.Model.StatHashMaiusc;
import it.facebook.univpm.Facebook.Post.Util.Lunghezze;
/* 	QUESTO TESTCASE EFFETTUA TEST SU
 * 	MEDIA, MAX E MIN
 * 	NUMERO DI POST CON PRESENZA DI HASHTAG
 * 	NUMERO DI POST CON TESTO ESCLUSIVAMENTE IN MAIUSCOLO
 *	@author Matteo Sonaglioni
 */
class TestStats {
	private Vector<Info> v;
	private String AccessToken= "EAAksDd12x1IBAAMzh6vsYtRDaZCfUOqKs3a3bYuN1un4IHCbZCTGkhi7jjFNevd8IOpLdydy3ZBDmQZBM2ie2ED0fhofpOKYV4flaLGrRGpPblcxWNSuj4nkIsgI6jAgSi4UX8HqVX0VVFTFiXeiHeauAaeybQ8jgmgXziwG0eDOo1pEZC6QT";
	private int hashtag;
	private int maiusc;
	
	@BeforeEach
	void setUp() throws Exception {
		v = new Vector<Info>();
		PagedList<org.springframework.social.facebook.api.Post> L;
		FacebookTemplate facebook = new FacebookTemplate(AccessToken);
		L= facebook.feedOperations().getFeed(new PagingParameters(1,0,null,null)); 
	
		while(L.size()>0) {
			PagingParameters pp= L.getNextPage();
			L = facebook.feedOperations().getFeed(pp);
			for(Post P : L) {
				if(P.getMessage()!=null) {
					Info i = new Info(P.getMessage());				
					v.add(i);				
				}
			}		
		}
		StatHashMaiusc s = new StatHashMaiusc(v);
		this.hashtag=s.getPwH();
		this.maiusc=s.getPwM();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMedia() {
		assertEquals(23, Lunghezze.media(v));
	}

	@Test
	void testMax() {
		assertEquals(91, Lunghezze.massimo(v));
	}
	
	@Test
	void testMin() {
		assertEquals(3, Lunghezze.minimo(v));
	}
	
	@Test
	void testHashtag() {
		assertEquals(2, this.hashtag);
	}
	
	@Test
	void testMaiusc() {
		assertEquals(1, this.maiusc);
	}
}

