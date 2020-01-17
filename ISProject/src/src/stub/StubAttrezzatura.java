package stub;

import entity.Attrezzatura;
import entity.Socio;

import java.util.ArrayList ;
import java.util.Date; 

public class StubAttrezzatura {


	private String tipo ;
	private int IdAttrezzo ;
	private boolean availability ;
	private StubSocio sb ;
	
	
	public StubAttrezzatura( String tipo, int IdAttrezzo ) {
		
		this.tipo = tipo ;
		this.IdAttrezzo = IdAttrezzo ;
		this.availability = false ;
		
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getIdAttrezzo() {
		return IdAttrezzo;
	}


	public void setIdAttrezzo(int idAttrezzo) {
		IdAttrezzo = idAttrezzo;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public StubSocio getS() {
		return sb;
	}


	public void setS(StubSocio s) {
		this.sb = s;
	}
	
	
}
