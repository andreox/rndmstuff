SELECT A.Numero_Terminal, A.Altitudine FROM AEROPORTI A WHERE A.Codice = 'FRA' ;

SELECT A.Codice, A.Nome, A.Numero_Terminal, A.Altitudine FROM AEROPORTI A, VOLI V WHERE V.Aeroporto_Partenza = A.Codice AND A.Nazione = 'ITALIA' ; 

SELECT U.Nome , U.Passaporto, U.Cognome FROM UTENTI U, PRENOTAZIONI P WHERE U.ID = P.Utente ORDER BY U.Cognome ASC ;

SELECT V.Codice, V.Ora_Partenza , V.Aeroporto_Arrivo FROM VOLI V, AEROPORTI A WHERE V.Aeroporto_Partenza = A.CODICE AND A.CODICE = 'NAP' ;

SELECT U.Passaporto, U.Nome, U.Cognome, P.Classe , P.Lista_Servizi FROM UTENTI U, PRENOTAZIONI P WHERE U.ID = P.Utente AND P.Volo = 'LH456' AND P.Data = '21-Jul-2019' ;

SELECT U.ID, U.Cognome , U.Nome, U.Passaporto, V.Codice, V.Aeroporto_Partenza, V.Aeroporto_Arrivo, V.Data_Inizio, V.Data_Fine 
FROM VOLI V, UTENTI U, PRENOTAZIONI P  
WHERE V.Codice = P.Volo AND P.Utente = U.ID  
ORDER BY U.Cognome ASC ;

SELECT A.Codice, A.Nome , COUNT(*) AS Numero_Voli_Partenza  
FROM AEROPORTI A , VOLI V  
WHERE A.Codice = V.Aeroporto_Partenza  
GROUP BY A.Codice, A.Nome ;

SELECT A.Nome, A.Numero_Terminal 
FROM AEROPORTI A 
GROUP BY A.Nome, A.Numero_Terminal 
HAVING A.Numero_Terminal >= ALL( SELECT A.Numero_Terminal FROM Aeroporti A ) ;

SELECT A.Nome 
FROM AEROPORTI A 
MINUS 
SELECT A.Nome FROM AEROPORTI A, VOLI V WHERE A.Codice = V.Aeroporto_Partenza OR A.Codice = V.Aeroporto_Arrivo ;

CREATE MATERIALIZED VIEW UTENTI_PRENOTATI 
AS 
SELECT U.ID, U.Nome as Nome , U.Cognome as Cognome , U.Passaporto as Passaporto, COUNT(*) AS Prenotazioni_eff 
FROM UTENTI U, PRENOTAZIONI P, VOLI V 
WHERE U.ID = P.Utente AND V.Codice = P.Volo 
GROUP BY U.ID,U.Nome,U.Cognome,U.Passaporto ;
SELECT UT.ID, UT.Nome, UT.Cognome, UT.Prenotazioni_eff 
FROM UTENTI_PRENOTATI UT 
WHERE UT.Prenotazioni_eff = ( SELECT MAX(UK.Prenotazioni_eff) FROM UTENTI_PRENOTATI UK) ;







