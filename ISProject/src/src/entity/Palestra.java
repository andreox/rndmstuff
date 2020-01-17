package entity;
import java.util.ArrayList ;

import java.util.Calendar ;
import java.util.GregorianCalendar;
import java.util.Date ;
import stub.StubSocio;
import stub.StubAccessi;
import stub.StubAttrezzatura;
import stub.StubPalestra;

public class Palestra {

	private ArrayList<Socio> Soci  ;
	private ArrayList<Accesso> Accessi ;
	private ArrayList<Attrezzatura> Attrezzature ;

	private static Palestra istance = null ;
	
	private Palestra() {
		
		StubPalestra p = new StubPalestra() ;
		
		Soci = new ArrayList<Socio>() ;
		Accessi = new ArrayList<Accesso>() ;
		Attrezzature = new ArrayList<Attrezzatura>() ;
		
		for ( int i = 0 ; i < p.Soci.size(); i++ ) {
			
			Socio s = new Socio( p.Soci.get(i).getNome(), p.Soci.get(i).getCognome(),p.Soci.get(i).getDatanascita(),p.Soci.get(i).getTelefono(),p.Soci.get(i).getDatascadenzacertificato(),p.Soci.get(i).getDatascadenzaiscrizione(),p.Soci.get(i).getCodice_badge()) ;
			Soci.add(s) ;
			
		}
		
		for ( int i = 0 ; i < p.Soci.size(); i++) {
			
			Attrezzatura a = new Attrezzatura( p.Attrezzi.get(i).getTipo(), p.Attrezzi.get(i).getIdAttrezzo()) ;
			Attrezzature.add(a) ;
			
		}
		
		for ( int i = 0 ; i < p.Accessi.size(); i++ ) {
			
			Accesso a1 = new Accesso( p.Accessi.get(i).getDataingresso(),p.Accessi.get(i).getOraingresso()) ;
			a1.setS(Soci.get(0)) ;
			Accessi.add(a1) ;
			
		}
		
	}
	
	//Implementazione Singleton
	public static Palestra getInstance() {
		
		if ( istance == null ) istance = new Palestra() ;
		return istance ;
		
	}
	
	public void addSocio( Socio s ) {
		
		Soci.add(s) ;
		
	}
	
	public void addAttrezzatura( Attrezzatura a ) { Attrezzature.add(a) ; }
	
	//Aggiungo un accesso da parte di un socio, utilizzo la libreria Calendar per ottenere le variabili da utilizzare nel costruttore di Accesso

	/*public void accedi( Socio s ) {
		
		Date date = new Date() ;
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY) ;
		Accesso a = new Accesso( date, hour );
		a.setS(s);
		Accessi.add(a) ;
		
	}
	*/
	public boolean esci( Socio s1 ) {
		
		for ( int i = 0 ; i < Accessi.size(); i++ ) {
			
			if ( Accessi.get(i).getS().equals(s1) && Accessi.get(i).getDataUscita() == null ) {
				
				Date date = new Date() ;
				Calendar c = GregorianCalendar.getInstance();
				c.setTime(date);
				int hour = c.get(Calendar.HOUR_OF_DAY) ;
				Accessi.get(i).setDataUscita(date);
				Accessi.get(i).setOraUscita(hour);
				
				if ( s1.getAttr() != null )
					s1.getAttr().delS();
					
				
				System.out.println("Socio "+s1.getCodice_badge()+" è uscito dalla palestra alle "+Accessi.get(i).getDataUscita()) ;
				return true ;
				
			}
		}
		
		return false ;
	}
	
	public boolean verificaAccesso( Socio s1 ) {
		
		for ( int i = 0 ; i < Accessi.size(); i++ ) {
			
			if ( Accessi.get(i).getS().equals(s1) && Accessi.get(i).getDataUscita() == null ) 
				
				return true ;
				
			
		}
		
		return false ;
	}
	
	public ArrayList<Socio> showElencoSoci() {
		
		return Soci ;
		
	}
	
	public Socio richiediSocio( String codice_badge ) {
		
		for ( int i = 0 ; i < Soci.size(); i++ ) {
			
			if ( Soci.get(i).getCodice_badge().contentEquals(codice_badge))  return Soci.get(i) ;
		}
		
		return null ;
		
	}
	public int RichiediAttrezzatura( String tipo , String codice_badge ) {
		
		Socio s1 = richiediSocio(codice_badge) ;
		
		if (  s1 == null ) {
			//System.out.println("Socio non iscritto") ;
			return -1 ;
		}
		
		if ( !verificaAccesso( s1 ) ) {
			//System.out.println("Socio non ha effettuato l'accesso");
			return -2 ;
		}
		
		if ( !(s1.getAttr() == null) ) {
			
			//System.out.println("Socio "+s1.getNome()+" "+s1.getCognome()+" sta già utilizzando un'attrezzatura") ;
			return -3 ;
		}
		
		for ( int i = 0 ; i < Attrezzature.size(); i++ ) {
			
			if ( Attrezzature.get(i).getTipo().equals(tipo) && Attrezzature.get(i).isAvailable() ) {
				
				Attrezzature.get(i).setAvailability(false) ;
				Attrezzature.get(i).setS(s1);
				s1.setAttr(Attrezzature.get(i)) ;
				System.out.println("Attrezzatura "+Attrezzature.get(i).getIdAttrezzo()+" assegnata al socio") ;
				return 0 ;
			}
		}
		
		//System.out.println("Tutte le attrezzature del tipo sono occupate") ;
		return -4 ;
		
	}
}
