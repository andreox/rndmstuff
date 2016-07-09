#include <stdio.h>

int main() {

	
	printf("n s c t\n");
	for( int n = 0 ; n <= 100 ; n++ ) {

		int s = n*n ;
		int c = n*n*n ;
		printf("%d %d %d %d\n",n,s,c,n+s+c) ;

	}

	return 0 ;

}
