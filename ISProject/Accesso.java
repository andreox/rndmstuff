import java.util.Date ;

public class Accesso {

	private Date dataingresso ;
	private int oraingresso ;
	private int orauscita ;
	private Date datauscita ;
	private Socio s ;
	
	Accesso() {}
	
	public Accesso( Date di, int oi ) {
		
		this.dataingresso = di ;
		this.oraingresso = oi ;
		this.datauscita = null ;
		
	}
	
	Date getDataIngresso() { return this.dataingresso ; }
	int getOraIngresso() { return this.oraingresso ; }
	int getOraUscita() { return this.orauscita ; }
	Date getDataUscita() { return this.datauscita ; }
	
	void setDataIngresso( Date d ) { this.dataingresso = d ; }
	void setOraIngresso( int oi ) { this.oraingresso = oi ; }
	void setOraUscita( int ou ) { this.orauscita = ou ; }
	void setDataUscita( Date d ) { this.datauscita = d ; }

	public Socio getS() {
		return s;
	}

	public void setS(Socio s) {
		this.s = s;
	}
	
	
}
