<?php

require_once 'connec.php';

$req = "select * from patient";
$ps=$pdo->prepare($req);
$ps->execute();
$list=$ps->fetchAll(PDO::FETCH_ASSOC);
header("Content-Type:application/json");
echo(json_encode($list));

?>