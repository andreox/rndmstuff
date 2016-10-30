import java.io.* ;

public class UseServer {

	public static void main( String[] args ) {
	
		Server server = new Server() ;
		server.initConnection() ;
		String input ;
		
		boolean tr = true ;
		
		while( tr ) {
		
			input = server.leggiStream() ;
			if ( input.equals("FINE") ) System.exit(1) ;
			System.out.println("Client : "+input);
			String answer = "ECHO : "+input ;
			server.scriviStream(answer) ;
			
		}
		
		server.closeConnection() ;
		
	}
	
}
