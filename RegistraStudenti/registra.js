var i = 0 ;
var studenti = new Array() ;

function RegistraStudente() {

	var studente = document.modulo.cognome.value + " " + document.modulo.nome.value ;
	document.modulo.cognome.value = "" ;
	document.modulo.nome.value = "" ;
	studenti[i] = studente ;
	i++ ;

}

function VisualizzaStudenti() {

	var j = 0 ;
	document.write("<table><tr><th>Cognome</th><th>Nome</th></tr>") ;
	for ( j = 0 ; j < i ; j++ ) {

		document.write("<tr><td>"+studenti[j]+"</td></tr>") ;

	}

	document.write("</table>") ;
}
