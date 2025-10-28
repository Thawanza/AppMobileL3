<?php

try {
    $strconnection='mysql:host=localhost;dbname=analyzeme';
    $arrExtraParam=array(PDO::MYSQL_ATTR_INIT_COMMAND=>"SET NAMES utf8 ");
    $pdo= new PDO($strconnection, 'root', '',$arrExtraParam);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    $msg='erreur pdo dans:'.$e->getFile().' L'.$e->getLine().':'.$e->getMessage();
    die($msg);
    
}
?>