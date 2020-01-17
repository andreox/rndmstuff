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
	
	public StubAccessi() {
		
		Date date = new Date() ;
		this.sb = new StubSocio("Alessio","Andreozzi",date,"333",true,date,date,"001") ;
		this.dataingresso = date ;
		this.datauscita = null ;
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY) ;
		this.oraingresso = hour ;

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
