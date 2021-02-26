<?php

try{	
	$host="mysql:host=localhost;dbname=dbName";
	$user_name="username";
	$user_password="password";
	$db=new PDO($host,$user_name,$user_password);
}
catch(Exception $e){
	exit("Connection Error ".$e->getMessage());
}

?>