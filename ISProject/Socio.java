
import java.util.Date ;

public class Socio {

	private String nome ;
	private String cognome ;
	private Date datanascita ;
	private String telefono ;
	private boolean disponibilita_certificato ;
	private Date datascadenzacertificato ;
	private Date datascadenzaiscrizione ;
	private String codice_badge ;
	private Attrezzatura attr ;
	
	Socio() {}
	
	public Socio( String nome, String cognome, Date datanascita, String telefono, Date dsc, Date dsi, String codice_badge ) {
		
		this.nome = nome ;
		this.cognome = cognome ;
		this.datanascita = datanascita ;
		this.telefono = telefono ;
		this.disponibilita_certificato = true ;
		this.datascadenzacertificato = dsc ;
		this.datascadenzaiscrizione = dsi ;
		this.codice_badge = codice_badge ;
		this.attr = null ;
		
	}
	
	String getNome() { return this.nome ; }
	String getCognome() { return this.cognome ; }
	Date getDataNascita() { return this.datanascita ; }
	String getTelefono() { return this.telefono ; }
	boolean getDisponibilitaCertificato() { return this.disponibilita_certificato ; }
	Date getDataScadenzaCertificato() { return this.datascadenzacertificato ; }
	Date getDataScadenzaIscrizione() { return this.datascadenzaiscrizione ; }
	String getCodiceBadge() { return this.codice_badge ; }

	void setNome( String s ) { this.nome = s ; }
	void setCognome( String s ) { this.cognome = s ; }
	void setDataNascita( Date d ) { this.datanascita = d ; }
	void setTelefono( String s ) { this.telefono = s ; }
	void setCertificatoDisponibile() { this.disponibilita_certificato = true ; }
	void setDataScadenzaCertificato( Date d ) { this.datascadenzacertificato = d ; }
	void setDataScadenzaIscrizione( Date d ) { this.datascadenzaiscrizione = d ; }
	void setCodiceBadge( String s ) { this.codice_badge = s ; }

	public Attrezzatura getAttr() {
		return attr;
	}

	public void setAttr(Attrezzatura attr) {
		this.attr = attr;
	}
	
	
	
}
