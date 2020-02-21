import java.util.LinkedList ;
import java.util.Queue ;

public class PostFixExpr {

	public static void main( String args[] ) {
		
			Queue<Integer> operandi = new LinkedList<>() ;
			Queue<Character> operatori = new LinkedList<>() ;
			
			operandi.add(2) ;
			operandi.add(3) ;
			operandi.add(2) ;
			operandi.add(5) ;
			operatori.add('+') ;
			operatori.add('+') ;
			operatori.add('*') ;
			
			while( operandi.size() != 1 && operatori.size() != 0 ) {
				
				int x1 = operandi.remove();
				int x2 = operandi.remove();
				char operatore = operatori.remove() ;
				
				if ( operatore == '+' ) {
					
					operandi.add(x1+x2) ;
					
				}
				
				else if ( operatore == '-') {
					operandi.add(x1-x2) ;
					
				}
				
				else if ( operatore == '*') {
					
					operandi.add(x1*x2) ;
				}
				
				else if ( operatore == '/') {
					
					operandi.add(x1/x2) ;
				}
			}
			
			System.out.println("Operandi : "+operandi) ;
	}
}
