import java.io.* ;
import java.util.* ;

public class Professore {
	
	BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) ) ;
	Queue<Genitore> coda = new LinkedList<Genitore>() ;
	int numero_attuale , numero_max , codice ;
	String nome , cognome ;
	
	Professore(String nome , String cognome , int codice ) {
		
		numero_attuale = 1 ;
		numero_max = 1 ;
		
		this.nome = nome ;
		this.cognome = cognome ;
		this.codice = codice ;
		
	}
	
	void printInfo() {
		
		System.out.println("NOME : "+nome) ;
		System.out.println("COGNOME : "+cognome) ;
		System.out.println("CODICE : "+codice) ;
		try {
			
			Genitore g = coda.element() ;
			System.out.println("NUMERO ATTUALE : "+g.getId() ) ;
			System.out.println("GENITORE : "+g.getNome()+" "+g.getCognome()) ;
			
		}
		
		catch( NoSuchElementException ex ) {
			
			System.out.println("LIBERO. Si attendono Prenotazioni.");
			
		}
		
		
		
	}
	
	void prenotaNumero() {
		
		try {
			String nom , cognom ;
			int  cod ;
			System.out.println("Inserire il nome del genitore : ");
			nom = input.readLine() ;
			System.out.println("Inserire il cognome del genitore : ");
			cognom = input.readLine() ;
			cod = numero_max ;
			Genitore g = new Genitore( nom , cognom , cod ) ;
			coda.add(g) ;
			
			System.out.println("\n\nINCONTRI PROF "+nome+" "+cognome);
			System.out.println("Numero "+numero_max+" Prenotato!");
			numero_max++ ;
		
		}
	
		catch( IOException ex ) { System.out.println("ERRORE NELL'I/O"); }
		
	}
	
	void segnalaFineColloquio() {
		
		System.out.println("\n\nINCONTRI PROF "+nome+" "+cognome);
			
			try {
				Genitore g = coda.remove() ;
				System.out.println("Colloquio del Genitore "+g.getNome()+" "+g.getCognome()+" con codice "+g.getId()+" Terminato!") ;
			}
			
			catch( NoSuchElementException ex ) {
				
				System.out.println("Non sono state ancora effettutate prenotazioni!");
				
			}
			numero_attuale++ ;
			try {
				Genitore prossimo = coda.element() ;
				System.out.println("Avanti il Genitore "+prossimo.getNome()+" "+prossimo.getCognome()+" con codice "+prossimo.getId()) ;
			}
			
			catch( NoSuchElementException ex ) 	{
				
				System.out.println("Numero di Genitori in attesa terminato. Si attendono ulteriori prenotazioni.");
				
			}
		
	}
	
	void setCodice( int cod ) { codice = cod ; }
	void setNome( String n ) { nome = n ; }
	void setCognome( String c ) { cognome = c ; } 
	
}
