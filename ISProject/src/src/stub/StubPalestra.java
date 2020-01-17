package stub;

import java.util.ArrayList ;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar; 

public class StubPalestra {

	public ArrayList<StubSocio> Soci ;
	public ArrayList<StubAccessi> Accessi ;
	public ArrayList<StubAttrezzatura> Attrezzi ;
	
	public StubPalestra() {
		
		Date date = new Date() ;
		this.Soci = new ArrayList<StubSocio>() ;
		this.Accessi = new ArrayList<StubAccessi>() ;
		this.Attrezzi = new ArrayList<StubAttrezzatura>() ;
		
		StubSocio s_s = new StubSocio("Alessio","Andreozzi",date,"333",true,date,date,"001") ;
		StubAttrezzatura s_attr = new StubAttrezzatura("Bilanciere curvo",1) ;
		
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY) ;

		StubAccessi s_acc = new StubAccessi(date,hour,s_s) ;
		
		Soci.add(s_s) ;
		Accessi.add(s_acc) ;
		Attrezzi.add(s_attr) ;
		
	}
}
