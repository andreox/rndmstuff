
public class AutoVeicolo extends Veicolo {
	
	int numeroporte ;
	
	AutoVeicolo( String targa, String modello, String marca, int numeroposti, int numeroporte ) {
		
		super( targa, modello, marca, numeroposti) ;
		this.numeroporte = numeroporte ;
		
	}

	public int getNumeroporte() {
		return numeroporte;
	}

	public void setNumeroporte(int numeroporte) {
		this.numeroporte = numeroporte;
	}
	
	String veic_toString() {
		
		return super.veic_toString() + " " + numeroporte ;
		
	}

}
