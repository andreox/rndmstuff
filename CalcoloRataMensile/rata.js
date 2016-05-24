function Calcola() {

	var C = document.modulo.C.value ;
	var TA = document.modulo.TA.value ;
	var A = document.modulo.A.value ;
	var PA = 12 ;

	var fat1 = ( 1 + TA/PA ) ;
	var fat2 = PA*A ;
	var fat3 = C*Math.pow(fat1,fat2) ;
	var fat4 = (TA/PA) / (Math.pow(fat1,fat2)-1) ;
	var rata = fat3 * fat4 ;

	alert("La rata mensile da pagare e' : "+rata) ;

}
