package controller;

import java.util.Date ;
import entity.Palestra;
import entity.Socio; 
import entity.Attrezzatura;


public class Controller {

	private Palestra p ;
	
	public Controller() {
		
		p = Palestra.getInstance() ;
	
		
	}
	
	public int richiediAttrezzo ( String tipo, String badge ) {
		
		return p.RichiediAttrezzatura(tipo, badge) ;
		
	}
}
