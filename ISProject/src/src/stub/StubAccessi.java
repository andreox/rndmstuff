package stub;

import entity.Accesso;
import entity.Socio;

import java.util.ArrayList ;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StubAccessi {
	
	private Date dataingresso ;
	private int oraingresso ;
	private int orauscita ;
	private Date datauscita ;
	private StubSocio sb ;
	
	public StubAccessi( Date dataingresso, int oraingresso, StubSocio sb) {
		
		this.sb = sb ;
		this.dataingresso = dataingresso ;
		this.datauscita = null ;
		this.oraingresso = oraingresso ;

	}

	public Date getDataingresso() {
		return dataingresso;
	}

	public void setDataingresso(Date dataingresso) {
		this.dataingresso = dataingresso;
	}

	public int getOraingresso() {
		return oraingresso;
	}

	public void setOraingresso(int oraingresso) {
		this.oraingresso = oraingresso;
	}

	public int getOrauscita() {
		return orauscita;
	}

	public void setOrauscita(int orauscita) {
		this.orauscita = orauscita;
	}

	public Date getDatauscita() {
		return datauscita;
	}

	public void setDatauscita(Date datauscita) {
		this.datauscita = datauscita;
	}

	public StubSocio getSb() {
		return sb;
	}

	public void setSb(StubSocio sb) {
		this.sb = sb;
	}
	
	
	
}
