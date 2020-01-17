package entity;
import java.util.ArrayList ;
import java.util.Calendar ;
import java.util.GregorianCalendar;
import java.util.Date ;
import stub.StubSocio;
import stub.StubAccessi;
import stub.StubAttrezzatura;

public class Palestra {

	private ArrayList<Socio> Soci  ;
	private ArrayList<Accesso> Accessi ;
	private ArrayList<Attrezzatura> Attrezzature ;
	private StubSocio s_s ;
	private StubAttrezzatura s_attr ;
	private StubAccessi s_acc ;
	private static Palestra istance = null ;
	
	private Palestra() {
		
		Date date = new Date() ;
		s_s = new StubSocio("Alessio","Andreozzi",date,"333",true,date,date,"001") ;
		s_attr = new StubAttrezzatura() ;
		s_acc = new StubAccessi() ;
		
		Soci = new ArrayList<Socio>() ;
		Accessi = new ArrayList<Accesso>() ;
		Attrezzature = new ArrayList<Attrezzatura>() ;
		
		Socio s = new Socio( s_s.getNome(), s_s.getCognome(),s_s.getDatanascita(),s_s.getTelefono(),s_s.getDatascadenzacertificato(),s_s.getDatascadenzaiscrizione(),s_s.getCodice_badge()) ;
		Attrezzatura a = new Attrezzatura( s_attr.getTipo(),s_attr.getIdAttrezzo()) ;
		Accesso a1 = new Accesso( s_acc.getDataingresso(),s_acc.getOraingresso()) ;
		a1.setS(s) ;
		
		Soci.add(s) ;
		Attrezzature.add(a) ;
		Accessi.add(a1) ;
		
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
