package it.facebook.univpm.Facebook.Post.Filters;
/*	FILTRI PER LUNGHEZZE DEI POST
 * 	@author Lorenzo Toscanelli
 */
import java.util.Vector;

import it.facebook.univpm.Facebook.Post.Model.Info;
import it.facebook.univpm.Facebook.Post.Util.Lunghezze;

public class FiltriLunghezza {
		
	private String tipo;
	

	public FiltriLunghezza(String tipo) {
		this.tipo=tipo;
	}
	
	public Vector<Info> filtered (Vector<Info> v) {

		switch(tipo) {
			case "min" :{
				v=minMedia(v);
			}
			case "mag" : {
				v=magMedia(v);
			}			
			case "equal" : {
				v=equals(v);
			}
		}
		return v;
	}
	
	public Vector<Info> minMedia (Vector<Info> v) {
		
		Vector<Info> p = new Vector<Info>();
		for(int i=0;i<v.size();i++) {
			if(v.elementAt(i).getLength()<Lunghezze.media(v)) {
				Info info = new Info(v.elementAt(i).getMessage());
				p.add(info);
			}
		}
		return p;
	}
		
	public Vector<Info> magMedia (Vector<Info> v) {
		Vector<Info> p = new Vector<Info>();
		for(int i=0;i<v.size();i++) {
			if(v.elementAt(i).getLength()>Lunghezze.media(v)) {
				Info info = new Info(v.elementAt(i).getMessage());
				p.add(info);
			}
		}
		return p;
	}
	
	public Vector<Info> equals (Vector<Info> v) {
		Vector<Info> p = new Vector<Info>();
		for(int i=0;i<v.size();i++) {
			if(v.elementAt(i).getLength()==Lunghezze.media(v)) {
				Info info = new Info(v.elementAt(i).getMessage());
				p.add(info);
			}
		}
		return p;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
