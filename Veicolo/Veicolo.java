
public class Veicolo {

	String targa ;
	String modello ;
	String marca ;
	int numeroposti ;
	
	Veicolo( String targa, String modello, String marca, int numeroposti ) {
		
		this.targa = targa ;
		this.modello = modello ;
		this.marca = marca ;
		if ( numeroposti < 1 ) {
			
			System.out.println("Errore! Numero di posti deve essere almeno 1 ") ;
			this.numeroposti = -1 ; //Valore di default settato e deciso da noi
		}
		
		else this.numeroposti = numeroposti ;
		
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumeroposti() {
		return numeroposti;
	}

	public void setNumeroposti(int numeroposti) {
		this.numeroposti = numeroposti;
	}
	
	String veic_toString() {
		return targa+" "+modello+" "+marca+" "+numeroposti ;
		
	}
	
}
