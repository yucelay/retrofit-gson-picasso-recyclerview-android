<?php


header('Content-Type: application/json');

require_once('db.php');
$output=array();

$conn=$db->prepare('SELECT * FROM user');
$conn->execute();
$results=$conn->fetchAll(PDO::FETCH_ASSOC);
echo json_encode($results);


?>