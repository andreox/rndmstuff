
public class Attrezzatura {

	private String tipo ;
	private int IdAttrezzo ;
	private boolean availability ;
	private Socio s ;
	
	public Attrezzatura(String tipo, int idAttrezzo) {
		super();
		this.tipo = tipo;
		IdAttrezzo = idAttrezzo;
		this.availability = true;
		this.s = null ;
		
	}
	
	public Socio getS() {
		return s;
	}
	public void setS(Socio s) {
		this.s = s;
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
	public boolean isAvailable() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	
}
