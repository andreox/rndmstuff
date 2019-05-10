CREATE TABLE PERSONE( CODFIS VARCHAR(16),
                      NOME VARCHAR(10),
                      COGNOME VARCHAR(20),
                      INDIRIZZO VARCHAR(50),
                      CONSTRAINT PK_PERSONE PRIMARY KEY(CODFIS)) ;
                      
                      
CREATE TABLE VETTURE( TARGA VARCHAR(7) ,
                      CASA_COSTRUTTRICE VARCHAR(20),
                      MODELLO VARCHAR(20),
                      codper VARCHAR(5),
                      CONSTRAINT PK_VETTURE PRIMARY KEY(TARGA),
                      CONSTRAINT FK_VETTURE_PERSONE FOREIGN KEY(codper) REFERENCES PERSONE(CODFIS)) ;
                      
INSERT INTO PERSONE VALUES( 001 , 'Alessio' , 'Andreozzi' , 'Via Sg' ) ;
INSERT INTO PERSONE VALUES( 002, 'Stefano' , 'Cecere' , 'Via skrt' ) ;
INSERT INTO VETTURE VALUES( 01 , 'Audi' , 'A1' , 001 ) ;
INSERT INTO VETTURE VALUES( 02, 'Fiat' , 100 , 002 ) ;
INSERT INTO VETTURE VALUES( 03 , 'Alfa Romeo' , 'Giulietta' , 001 ) ;

SELECT P.NOME , COUNT(*) AS Num_Aut_Poss
FROM PERSONE P , VETTURE V
WHERE P.CODFIS = V.codper
GROUP BY P.NOME ORDER BY Num_Aut_Poss ASC ;

SELECT P.NOME , P.COGNOME
FROM PERSONE P
    MINUS SELECT DISTINCT P1.NOME, P1.COGNOME
    FROM PERSONE P1, VETTURE V
    WHERE P1.CODFIS = V.codper
    AND V.CASA_COSTRUTTRICE = 'Alfa Romeo'
    AND V.MODELLO = 'Giulietta' ;
