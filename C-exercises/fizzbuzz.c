#include <stdio.h>
#include <stdbool.h>

int main() {

	bool tr = true ;

	for ( int i = 1 ; i <= 100 ; i++ ) {

		if ( i % 3 == 0 ) { printf("Fizz") ; tr = false ; }
		if ( i % 5 == 0 ) { printf("Buzz") ; tr = false ; }
		if ( tr ) printf("%d",i) ;

		tr = true ;
		printf("\n") ;
	}

	return 0 ;

}
