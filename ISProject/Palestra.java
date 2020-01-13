import java.util.ArrayList ;
import java.util.Calendar ;
import java.util.GregorianCalendar;
import java.util.Date ;

public class Palestra {

	private ArrayList<Socio> Soci  ;
	private ArrayList<Accesso> Accessi ;
	private ArrayList<Attrezzatura> Attrezzature ;
	
	Palestra() {
		
		Soci = new ArrayList<Socio>() ;
		Accessi = new ArrayList<Accesso>() ;
		Attrezzature = new ArrayList<Attrezzatura>() ;
		
	}
	
	public void addSocio( Socio s ) {
		
		Soci.add(s) ;
		
	}
	
	//Aggiungo un accesso da parte di un socio, utilizzo la libreria Calendar per ottenere le variabili da utilizzare nel costruttore di Accesso

	public void accedi( Socio s ) {
		
		Date date = new Date() ;
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY) ;
		Accesso a = new Accesso( date, hour );
		a.setS(s);
		Accessi.add(a) ;
		
	}
	
	public void esci( Socio s1 ) {
		
		for ( int i = 0 ; i < Accessi.size(); i++ ) {
			
			if ( Accessi.get(i).getS().equals(s1) && Accessi.get(i).getDataUscita().equals(null) ) {
				
				Date date = new Date() ;
				Calendar c = GregorianCalendar.getInstance();
				c.setTime(date);
				int hour = c.get(Calendar.HOUR_OF_DAY) ;
				Accessi.get(i).setDataUscita(date);
				Accessi.get(i).setOraUscita(hour);
				
			}
		}
	}
	
	public boolean verificaAccesso( Socio s1 ) {
		
		for ( int i = 0 ; i < Accessi.size(); i++ ) {
			
			if ( Accessi.get(i).getS().equals(s1) && Accessi.get(i).getDataUscita().equals(null) ) 
				
				return true ;
				
			
		}
		
		return false ;
	}
	
	public ArrayList<Socio> showElencoSoci() {
		
		return Soci ;
		
	}
	
	public boolean richiediSocio( Socio s1 ) {
		
		for ( int i = 0 ; i < Soci.size(); i++ ) {
			
			if ( Soci.get(i).equals(s1) ) return true ;
		}
		
		return false ;
		
	}
	public boolean RichiediAttrezzatura( String tipo , Socio s1 ) {
		
		if ( !richiediSocio(s1) ) {
			System.out.println("Socio non iscritto") ;
			return false ;
		}
		
		if ( !verificaAccesso( s1 ) ) {
			System.out.println("Socio non ha effettuato l'accesso");
			return false ;
		}
		
		if ( s1.getAttr().equals(null)) {
			
			System.out.println("Socio "+s1.getNome()+" "+s1.getCognome()+" sta già utilizzando un'attrezzatura") ;
			return false ;
		}
		
		for ( int i = 0 ; i < Attrezzature.size(); i++ ) {
			
			if ( Attrezzature.get(i).getTipo().equals(tipo) && Attrezzature.get(i).isAvailable() ) {
				
				Attrezzature.get(i).setAvailability(false) ;
				Attrezzature.get(i).setS(s1);
				s1.setAttr(Attrezzature.get(i)) ;
				System.out.println("Attrezzatura "+Attrezzature.get(i).getIdAttrezzo()+" assegnata al socio") ;
				return true ;
			}
		}
		
		System.out.println("Tutte le attrezzature del tipo sono occupate") ;
		return false ;
		
	}
}
