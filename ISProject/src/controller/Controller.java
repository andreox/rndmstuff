package controller;

import java.util.Date ;
import entity.Palestra;
import entity.Socio; 
import entity.Attrezzatura;


public class Controller {

	private Palestra p ;
	
	public Controller() {
		
		p = new Palestra() ;
		//Inserisco valori ad-hoc per simulare persistenza dati
		Attrezzatura a = new Attrezzatura( "Bilanciere curvo", 1) ;
		Date datanascita = new Date( 1998, 7, 7) ;
		
		Socio s = new Socio( "Alessio", "Andreozzi", datanascita, "telefono", datanascita, datanascita, "001") ;
		p.addSocio(s); 
		p.addAttrezzatura(a);

		p.accedi(s);
		
	}
	
	public int richiediAttrezzo ( String tipo, String badge ) {
		
		return p.RichiediAttrezzatura(tipo, badge) ;
		
	}
}
