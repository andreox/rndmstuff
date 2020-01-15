package entity;

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
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(Date datanascita) {
		this.datanascita = datanascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isDisponibilita_certificato() {
		return disponibilita_certificato;
	}

	public void setDisponibilita_certificato(boolean disponibilita_certificato) {
		this.disponibilita_certificato = disponibilita_certificato;
	}

	public Date getDatascadenzacertificato() {
		return datascadenzacertificato;
	}

	public void setDatascadenzacertificato(Date datascadenzacertificato) {
		this.datascadenzacertificato = datascadenzacertificato;
	}

	public Date getDatascadenzaiscrizione() {
		return datascadenzaiscrizione;
	}

	public void setDatascadenzaiscrizione(Date datascadenzaiscrizione) {
		this.datascadenzaiscrizione = datascadenzaiscrizione;
	}

	public String getCodice_badge() {
		return codice_badge;
	}

	public void setCodice_badge(String codice_badge) {
		this.codice_badge = codice_badge;
	}

	public Attrezzatura getAttr() {
		if ( attr != null ) return attr ;
		return null ;
	}

	public void setAttr(Attrezzatura attr) {
		this.attr = attr;
	}
	
	
	
}
