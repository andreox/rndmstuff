
public class Prova {

	public static void main( String args[] ) {
		
		Veicolo v[] = {
				new AutoVeicolo( "AAA2", "A180D" , "MERCEDES-BENZ", 5, 5),
				new Veicolo("AA3","A3","AUDI",5),
				new AutoCarro( "AA1", "0W", "FIAT", 5, 320.50f ) 
		};
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			
			System.out.println(v[i].veic_toString()) ;
			
		}

	}
}
