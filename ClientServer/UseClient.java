import java.io.* ;

public class UseClient {

	public static void main( String[] args ) {
	
		Client client = new Client() ;
		String input_utente = null ;
		client.initConnection() ;
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) ) ;
		
		boolean tr = true ;
		
		while(tr) {
		
				
			try {
				input_utente = in.readLine() ;
			}
			
			catch(IOException ex ) {
			
				System.out.println("Errore lettura input") ;
				
			}
			
			client.scrivi(input_utente) ;
			if ( input_utente.equals("FINE") ) tr = false ;
			System.out.println("Server : "+client.leggi()) ;
			
		}
		
		client.closeConnection() ;
		
	}
	
}
