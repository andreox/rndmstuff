import java.io.* ;
import java.net.* ;

class Client {

	InetAddress addr ;
	Socket socket ;
	public BufferedReader in ;
	public PrintWriter out ;
	
	Client() {
	
		try {
			addr = InetAddress.getByName(null) ;
			socket = null ;
			in = null ;
		}
		
		catch ( IOException ex ) {
		
			System.exit(1) ;
			
		}
		
	}
	
	void initConnection() {
	
		try {
		
			socket = new Socket(addr, Server.PORT ) ;
			System.out.println("Client : Avviato") ;
			
			InputStreamReader isr = new InputStreamReader( socket.getInputStream()) ;
			in = new BufferedReader(isr) ;
			
			OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream()) ;
			BufferedWriter bw = new BufferedWriter(osw) ;
			out = new PrintWriter(bw , true) ;
			
			
		}
		
		catch ( IOException ex ) {
		
			System.exit(1) ;
			
		}
		
	}
	
	void scrivi( String s ) {
	
			out.println(s) ;
		
	}
	
	String leggi() {
	
		String read = null ;
		
		try {
		
			read = in.readLine() ;
			
		}
		
		catch( IOException ex ) {
		
			System.exit(1) ;
			
		}
		
		return read ;
		
	}
	
	void closeConnection() {
	
		try {
		
			System.out.println("Client in chiusura...") ;
			out.close() ;
			in.close() ;
			socket.close() ;
			
		}
		
		catch( IOException ex ) {
		
			System.out.println("Errore nella chiusura!");
			System.exit(1) ;
			
		}
		
	}
	
}
