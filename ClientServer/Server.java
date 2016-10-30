import java.io.* ;
import java.net.* ;

class Server {

	public static final int PORT = 1050 ;
	Socket clientSocket ;
	BufferedReader in ;
	PrintWriter out ;
	ServerSocket serverSocket ;
	
	Server() {
	
		clientSocket = null ;
		in = null ;
		out = null ;
		try {
			
			serverSocket = new ServerSocket(PORT) ;
			
		}
		
		catch(IOException ex) {
		
			System.exit(1) ;
			
		}
		
	}
	
	void initConnection() {
	
		try {
			clientSocket = serverSocket.accept() ;
			System.out.println("Connessione effettuata!");
			
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream()) ;
			in = new BufferedReader(isr) ;
			
			OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream()) ;
			BufferedWriter bw = new BufferedWriter(osw) ;
			out = new PrintWriter(bw , true) ;
			
		}
		
		catch( IOException e ) {
		
			System.err.println("Errore nella connessione");
			System.exit(1) ;
			
		}
		
	}
	
	String leggiStream() {
	
		String s = null ;
		try {
		
			s = in.readLine() ;
		}
		
		catch( IOException ex ) {
		
			System.out.println("Errore nella lettura dello stream");
			System.exit(1) ;
			
		}
		
		return s ;
	}
	
	void scriviStream(String s) {
	
		out.println(s) ;
		
	}
	
	void closeConnection() {
	
		try {
			System.out.println("Server in chiusura...");
			out.close();
			in.close() ;
			clientSocket.close() ;
			serverSocket.close() ;
			
		}
		
		catch( IOException ex ) {
		
			System.exit(1) ;
			
		}
		
	}
	
}
