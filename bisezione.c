//Algoritmo dicotomico per la funzione x^2 + x - 2 
#include <stdio.h>
#include <math.h>

float f( float x ) {
	
	return ( x*x + x - 2 ) ;
	
}

int main( int argc , char** argv ) {
	
	float a , b ;
	printf("Inserire il primo estremo : ");
	scanf("%f",&a) ;
	printf("Inserire il secondo estremo : ");
	scanf("%f",&b) ;
	
	if ( f(a) * f(b) < 0 ) printf("Esiste una radice nell'intervallo! Continuiamo..\n");
	else {
		
		printf("Non esiste una radice nell intervallo!\n");
		return 0 ;
		
	}
	
	float m = (a+b) / 2 ;
	
	float est1 = a ;
	float est2 = b ;
	while ( f(m) != 0 ) {
		
		if ( (f(m) > 0 && est1 < 0) || (f(m) < 0 && est1 > 0 ) ) {
			
			est1 = a ;
			est2 = m ;
			
		}
		
		else if ( (f(m) > 0 && est2 < 0 ) || ( f(m) < 0 && est2 > 0 ) ) {
			
			est1 = m ;
			est2 = b ;
			
		}
		
		m = ( est1 + est2 ) / 2 ;
		
	}
	
	printf("La funzione ha zeri nel punto : %f\n",m) ;
	
	return 0 ;
	
}
# math
# math
