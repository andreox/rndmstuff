
public class AutoCarro extends Veicolo {
	
	float caricomax ;
	
	AutoCarro( String targa, String modello, String marca, int numeroposti, float caricomax ) {
		
		super( targa, modello, marca, numeroposti) ;
		this.caricomax = caricomax ;
		
	}

	public float getCaricomax() {
		return caricomax;
	}

	public void setCaricomax(float caricomax) {
		this.caricomax = caricomax;
	}
	
	String veic_toString() {
		
		return super.veic_toString() + " " + caricomax ;
		
	}

}
