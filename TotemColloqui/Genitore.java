import java.io.* ;
import java.util.* ;

public class Genitore {
	
	String nome , cognome ;
	int id ;
	
	Genitore ( String nome , String cognome , int id ) {
		
		this.nome = nome ;
		this.cognome = cognome ;
		this.id = id ;
		
	}
	
	public String getNome() { return nome ; }
	public String getCognome() { return cognome ; }
	public int getId() { return id ; }
	
}
