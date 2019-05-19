CREATE TABLE RISTORANTI( CODICE VARCHAR(3) , NOME VARCHAR(5) , INDIRIZZO VARCHAR(8) , QUARTIERE VARCHAR(3) , CONSTRAINT PK_RIS PRIMARY KEY(CODICE)) ;
CREATE TABLE GASTRONOMIA( RISTORANTE VARCHAR(3) , TIPOCUCINA VARCHAR(20) ,
                        CONSTRAINT FK_GAS FOREIGN KEY(RISTORANTE) REFERENCES RISTORANTI(CODICE) , 
                        CONSTRAINT PK_GAS PRIMARY KEY( RISTORANTE, TIPOCUCINA )) ;
                        
INSERT INTO RISTORANTI VALUES( '001' , 'R1' , 'VIA1' , 'SCA' ) ;
INSERT INTO RISTORANTI VALUES( '002' , 'R2' , 'VIA2' , 'SCA' ) ;
INSERT INTO RISTORANTI VALUES( '003' , 'R3' , 'VIA3' , 'NAP' ) ;
INSERT INTO RISTORANTI VALUES( '004' , 'R4' , 'VIA4' , 'ROM' ) ;
INSERT INTO GASTRONOMIA VALUES( '001' , 'CINESE' ) ;
INSERT INTO GASTRONOMIA VALUES( '001' , 'ITALIANA' ) ;
INSERT INTO GASTRONOMIA VALUES( '002' , 'CINESE' ) ;
INSERT INTO GASTRONOMIA VALUES( '003' , 'CINESE' ) ;
INSERT INTO GASTRONOMIA VALUES( '004' , 'CINESE' ) ;

SELECT R.NOME, COUNT(*) AS NUM_TIPO
FROM RISTORANTI R JOIN GASTRONOMIA G ON R.CODICE = G.RISTORANTE 
GROUP BY R.NOME 
HAVING COUNT(*) >= 2 ;

SELECT R.QUARTIERE, COUNT(*) AS NUM_RIST
FROM RISTORANTI R JOIN GASTRONOMIA G ON R.CODICE = G.RISTORANTE AND G.TIPOCUCINA = 'CINESE'
GROUP BY R.QUARTIERE
HAVING COUNT(*) >= ALL( SELECT COUNT(*) FROM RISTORANTI R1 JOIN GASTRONOMIA G1 ON R1.CODICE = G1.RISTORANTE AND G1.TIPOCUCINA = 'CINESE' GROUP BY R1.QUARTIERE ) ;

/*SELECT R.QUARTIERE FROM RISTORANTI R JOIN GASTRONOMIA G ON R.CODICE = G.RISTORANTE 
HAVING COUNT( G.RISTORANTE ) > ALL( SELECT COUNT(G1.RISTORANTE) FROM GASTRONOMIA G1 WHERE G1.TIPOCUCINA = 'CINESE' GROUP BY G1.RISTORANTE   ;*/
