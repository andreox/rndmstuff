    <?php
    	$username = $_POST["username"] ;
        $password = $_POST["password"] ;
        $host = "localhost" ;
        $database = "my_alessioandreozzi" ;
        
        $db = mysql_connect($username,$password,$host,$database)or die("Errore nel collegamento");
        mysql_select_db($database,$db) or die("Errore");
        echo "Connessione avvenuta con successo!";
        $conn = new mysqli( $username , $password , $host , $database) ;
        
        $q = "SELECT NomePiatto, CalPiatto FROM Piatto" ;
        $result = $conn->query($q) ;
        
        echo "<br>";
        
        if ( $result->num_rows > 0 ) {
        
        	while ( $row = $result->fetch_assoc() ) {
            
            	echo "Nome Piatto : ".$row["NomePiatto"]." Calorie Piatto : ".$row["CalPiatto"]."<br>" ;
                
            }
        }
        
        else {
            echo "No results" ; 
        }       
        
        
       ?>
