CREATE TABLE PRODOTTI(
codice CHAR(5) PRIMARY KEY,
nome VARCHAR2(50),
categoria VARCHAR2(50),
qta INTEGER);

CREATE TABLE VENDITE (
id CHAR(5) PRIMARY KEY,
prodotto CHAR(5),
giorno INTEGER,
mese VARCHAR2(30),
anno INTEGER,
agente VARCHAR2(50),
qta_venduta INTEGER);

INSERT INTO PRODOTTI VALUES('PR001','scarpe calcetto','abbigliamento sportivo',30);
INSERT INTO PRODOTTI VALUES('PR002','tuta NAPOLI SSC','abbigliamento sportivo',20);
INSERT INTO PRODOTTI VALUES('PR003','felpa NAPOLI SSC','abbigliamento sportivo',20);
INSERT INTO PRODOTTI VALUES('PR004','Che C serve?','Libri',30);
INSERT INTO VENDITE VALUES ('VN001','PR001',13,'Marzo',2016,'Moscato',2);
INSERT INTO VENDITE VALUES ('VN002','PR001',11,'Dicembre',2016,'Moscato',4);
INSERT INTO VENDITE VALUES ('VN003','PR002',13,'Aprile',2016,'Picariello',3);
INSERT INTO VENDITE VALUES ('VN004','PR002',21,'Dicembre',2016,'Moscato',3);
INSERT INTO VENDITE VALUES ('VN005','PR003',23,'Dicembre',2016,'Chianese',3);
INSERT INTO VENDITE VALUES ('VN006','PR004',11,'Dicembre',2015,'Sansone',15);
COMMIT;

-- Query 1: Trovare per ogni prodotto (nome) venduto nel 2016 il numero totale (somma) di quantità vendute;
-- Query 2: Trovare il prodotto (nome) che non è mai stato venduto nel 2016

CREATE TABLE UTENTI (
username VARCHAR2(10) PRIMARY KEY,
pwd VARCHAR2(10),
Cognome VARCHAR2(50),
Punti INTEGER);

CREATE TABLE CARRELLI (
Utente VARCHAR2(10),
Prodotto VARCHAR2(50),
Data DATE,
QTA INTEGER,
CONSTRAINT PK_CARRELLI PRIMARY KEY(Utente,Prodotto,Data));

INSERT INTO UTENTI VALUES('vinni','wnapoli','MOSCATO',10);
INSERT INTO UTENTI VALUES('angchian','aglo','CHIANESE',30);
INSERT INTO UTENTI VALUES('picus','picachu','PICARIELLO',10);
INSERT INTO UTENTI VALUES('carlosan','carletto','SANSONE',10);
INSERT INTO CARRELLI VALUES ('vinni','Scarpe Calcetto','22-Nov-2016',1);
INSERT INTO CARRELLI VALUES ('carlosan','Scarpe Calcetto','22-Nov-2016',2);
INSERT INTO CARRELLI VALUES ('picus','Mouse','22-Nov-2016',1);
INSERT INTO CARRELLI VALUES ('angchian','Monitor','22-Nov-2016',1);
INSERT INTO CARRELLI VALUES ('angchian','Mouse','22-Nov-2016',2);
INSERT INTO CARRELLI VALUES ('carlosan','Monitor','20-Nov-2016',1);
INSERT INTO CARRELLI VALUES ('angchian','Tablet','20-Nov-2016',1);
INSERT INTO CARRELLI VALUES ('picus','Smart Phone','20-Nov-2016',3);
COMMIT;

-- Query 1: Trovare per ogni utente (cognome) il numero totale di acquisti effettuati ed ordinare il risultato sul  
-- Query 2: Trovare la lista di prodotti che non sono mai stati acquistati dall’utente ‘MOSCATO’;

CREATE TABLE ARTICOLI(
Codice CHAR(5) PRIMARY KEY,
Descrizione VARCHAR2(50),
Categoria VARCHAR2(50),
Giacenza NUMBER(2,0)
);

CREATE TABLE MOVIMENTAZIONI (
Id CHAR(5) PRIMARY KEY,
Prodotto CHAR(5),
Data DATE,
Deposito VARCHAR2(50),
Qta NUMBER(2,0)
);

insert into ARTICOLI values ('PR001', 'USB HD', 'Accessori Computer',80);
insert into ARTICOLI values ('PR002', 'USB Mouse', 'Accessori Computer',30);
insert into ARTICOLI values ('PR003', 'HTC 8 Mini', 'Cellulari',40);
insert into ARTICOLI values ('PR004', 'HTC 9', 'Cellulari',20);
insert into MOVIMENTAZIONI values ('TR001', 'PR001', '23-Dec-2015','Lab Agnano',3);
insert into MOVIMENTAZIONI values ('TR002', 'PR002', '24-Dec-2015','Lab Agnano',2);
insert into MOVIMENTAZIONI values ('TR003', 'PR002', '27-Dec-2015','MISLAB via Claudio',4);
insert into MOVIMENTAZIONI values ('TR004', 'PR004', '29-Dec-2015','MISLAB via Claudio',1);

commit;

-- Query 1: Trovare per ogni categoria di articoli il numero medio di quantità movimentate; 
-- Query 2: Trovare la descrizione degli articoli a cui corrisponde la giacenza massima

SELECT P.nome , SUM(V.qta_venduta) FROM PRODOTTI P , VENDITE V --1.1
WHERE P.codice = V.prodotto AND V.anno = 2016
GROUP BY P.nome ;

CREATE MATERIALIZED VIEW VENDITE16 AS SELECT P.codice AS COD FROM VENDITE V , PRODOTTI P WHERE V.prodotto = P.codice and V.anno = 2016 ;

SELECT P.nome FROM PRODOTTI P MINUS ( SELECT P1.nome FROM PRODOTTI P1 , VENDITE16 V1 WHERE P1.codice = V1.COD ) ; --1.2



SELECT U.cognome , SUM(C.QTA) FROM UTENTI U, CARRELLI C WHERE U.username = C.utente GROUP BY U.cognome ORDER BY SUM(C.QTA) ASC ; --2.1

CREATE MATERIALIZED VIEW MOSCATO AS SELECT C.utente AS ut FROM CARRELLI C , UTENTI U WHERE U.username = C.utente AND U.cognome = 'MOSCATO' ;

SELECT C.Prodotto FROM CARRELLI C MINUS ( SELECT C1.Prodotto FROM CARRELLI C1 , MOSCATO M WHERE M.ut = C1.Utente ) ;  --2.2




SELECT A.Categoria , AVG( M.Qta ) FROM ARTICOLI A , MOVIMENTAZIONI M WHERE A.Codice = M.Prodotto GROUP BY A.Categoria ; --3.1

SELECT A.Descrizione FROM ARTICOLI A WHERE A.Giacenza = ( SELECT MAX(A.Giacenza) FROM ARTICOLI A ) ;
