var Nomi = new Array() ;
var Cognomi = new Array() ;
var Date = new Array() ;
var Ruoli = new Array() ;
var Presenze = new Array() ;
var i = 0 ;
function Pulisci() {

	document.modulo.nome.value = "";
	document.modulo.cognome.value = "" ;
	document.modulo.data.value = "" ;
	document.modulo.ruolo.value = "" ;
	document.modulo.presenze.value = null ;
	
}

function Aggiungi() {

	Nomi[i] = document.modulo.nome.value ;
	Cognomi[i] = document.modulo.cognome.value ;
	Date[i] = document.modulo.data.value ;
	Ruoli[i] = document.modulo.ruolo.value ;
	Presenze[i] = document.modulo.presenze.value ;
	i++ ;
	Pulisci() ;
	
}
function ShowTable() {

	document.write(" <table> <tr> <th>Nome</th> <th>Cognome</th> <th>Data di Nascita</th> <th>Ruolo</th> <th>Presenze</th> </tr>" ) ;
	
	for ( var j = 0 ; j < i ; j++ ) {
	
		document.write("<tr>");
		document.write("<td> "+Nomi[j]+" </td>");
		document.write("<td> "+Cognomi[j]+"</td>");
		document.write("<td> "+Date[j]+"</td>") ;
		document.write("<td> "+Ruoli[j]+"</td>") ;
		document.write("<td> "+Presenze[j]+"</td>") ;
		document.write("</tr>");
		
	}
	
	document.write("</table>") ;
	
}

function VisualPres() {

	for ( var j = 0 ; j < i ; j++ ) {
	
		for ( var k = j+1 ; k < i ; k++ ) {
		
			if ( Presenze[j] < Presenze[k] ) {
			
				var tmp = Presenze[j] ;
				Presenze[j] = Presenze[k] ;
				Presenze[k] = tmp ;
				
				tmp = Nomi[j] ;
				Nomi[j] = Nomi[k] ;
				Nomi[k] = tmp ;
				
				tmp = Cognomi[j] ;
				Cognomi[j] = Cognomi[k] ;
				Cognomi[k] = tmp ;
				
				tmp = Date[j] ;
				Date[j] = Date[k] ;
				Date[k] = tmp ;
				
				tmp = Ruoli[j] ;
				Ruoli[j] = Ruoli[k] ;
				Ruoli[k] = tmp ;
				
			}
			
		}
		
	}
	
	ShowTable() ;

}

function VisualAlpha() {

	for ( var j = 0 ; j < i ; j++ ) {
	
		for ( var k = j+1 ; k < i ; k++ ) {
		
			if ( Ruoli[j].charAt(0) > Ruoli[k].charAt(0) ) {
			
				var tmp = Presenze[j] ;
				Presenze[j] = Presenze[k] ;
				Presenze[k] = tmp ;
				
				tmp = Nomi[j] ;
				Nomi[j] = Nomi[k] ;
				Nomi[k] = tmp ;
				
				tmp = Cognomi[j] ;
				Cognomi[j] = Cognomi[k] ;
				Cognomi[k] = tmp ;
				
				tmp = Date[j] ;
				Date[j] = Date[k] ;
				Date[k] = tmp ;
				
				tmp = Ruoli[j] ;
				Ruoli[j] = Ruoli[k] ;
				Ruoli[k] = tmp ;
			
			}
			
		}
		
	}
	
	ShowTable() ;
	
}
