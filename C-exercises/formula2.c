#include <stdio.h>

int square( int n ) { return n*n ; }

int main() {
	
	printf("n s c t\n");
	for ( int n = 0 ; n <= 100 ; n++ ) 	
		printf("%d %d %d %d\n",n,square(n) , square( square(n) ) , n+square(n)+square(square(n)));
		
	return 0 ;
	
}
	
