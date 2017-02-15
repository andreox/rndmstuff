CREATE TABLE Ricetta( CodRicetta INT , Procedimento VARCHAR(100) , PRIMARY KEY(CodRicetta));
CREATE TABLE Piatto( CodPiatto INT , Calorie INT , Descrizione VARCHAR(30) , CodRicetta INT , 
			FOREIGN KEY(CodRicetta) REFERENCES Ricetta(CodRicetta)) ;
CREATE TABLE Ingrediente( CodIngrediente INT , Nome VARCHAR(15) , Calorie INT , Tipo VARCHAR(10),
			PRIMARY KEY(CodIngrediente)) ;
CREATE TABLE Int_Table( CodRicetta INT , CodIngrediente INT , FOREIGN KEY(CodRicetta) REFERENCES
			Ricetta(CodRicetta) , FOREIGN KEY(CodIngrediente) REFERENCES Ingrediente(
			CodIngrediente)) ;
INSERT INTO Ricetta VALUES(001,'Bollire..');
INSERT INTO Piatto VALUES( 01 , 300 , "Pasta al Pomodoro" , 001 ) ;
INSERT INTO Ingrediente VALUES( 1 , "Spaghetti" , 81 ,  "Pasta") ;
INSERT INTO Ingrediente VALUES( 2 , "Pomodoro" , 50 , "Verdura" ) ;
INSERT INTO Ingrediente VALUES( 3 , "Olio di Oliva" , 20 , "Olio" );
INSERT INTO Int_Table VALUES( 001 , 1 ) ;
INSERT INTO Int_Table VALUES( 001 , 2 ) ;
INSERT INTO Int_Table VALUES( 001 , 3 ) ;

SELECT * FROM Ingredienti I WHERE I.Calorie > 80 ;
