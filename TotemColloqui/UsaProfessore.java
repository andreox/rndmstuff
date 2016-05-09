import java.io.* ;
import java.util.* ;

class UsaProfessore {
	
	public static void main( String[] args ) {
		
		try {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;
		String s ;
		int N ;
		System.out.print("Inserire il numero di professori : ") ;
		s = input.readLine() ;
		N = Integer.parseInt(s) ;
		
		Professore[] profs = new Professore[N] ;
		
		for ( int i = 0 ; i < N ; i++ ) {
			
			String n , c ;
			System.out.print("Inserire il nome del professore : ");
			n = input.readLine() ;
			
			System.out.print("Inserire il cognome del professore : ");
			c = input.readLine() ;
			
			profs[i] = new Professore( n , c , i ) ;
			
		}
		
		boolean tr = false ;
		
		while ( !tr ) {
			
			int scelta , cod ;
			
			System.out.println("\n\nMenu' di scelta.");
			System.out.println("1) Prenota Numero.");
			System.out.println("2) Segnala Fine Colloquio");
			System.out.println("3) Stampa Elenco Professori");
			System.out.println("4) Uscire"); 
			System.out.print("Inserire la scelta : ");
			s = input.readLine() ;
			scelta = Integer.parseInt(s) ;
			
			switch( scelta ) {
				
				case 1 :
				
					System.out.println("Inserire il codice del professore : ");
					s = input.readLine() ;
					cod = Integer.parseInt(s) ;
					if ( cod > N || cod < 0 ) {
						
						System.out.println("Errore! Inserire un codice valido.");
						
					}
					
					else {
						
						profs[cod].prenotaNumero() ;
						
					}
					
					break ;
					
				case 2 :
				
					System.out.println("Inserire il codice del professore : ");
					s = input.readLine() ;
					cod = Integer.parseInt(s) ;
					
					if ( cod > N || cod < 0 ) {
						
						System.out.println("Errore! Inserire un codice valido. ");
						
					}
					
					else {
						
						profs[cod].segnalaFineColloquio() ;
						
					}
					
					break ;
					
				case 3 :
				
					for ( int i = 0 ; i < N ; i++ ) {
						
						System.out.println("\n");
						profs[i].printInfo() ;
						System.out.println("\n");
						
					}
					break ;
					
				case 4 : 
					tr = true ;
					break ;
					
				}
				
				
			}
		
		}
		
		catch (IOException ex ) {} 
	}
	
}
