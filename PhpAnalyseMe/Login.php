<?php


require './conn.php';

if (isset($_POST['username']) && isset($_POST['password'])) {
    $user_name = $_POST["username"];
    $user_pass = $_POST["password"];

    // Utilisation de requêtes préparées pour éviter les injections SQL
    $mysql_query = "SELECT * FROM patient WHERE numerodetelephone = ? AND motdepasse = ?";
    $stmt = mysqli_prepare($conn, $mysql_query);
    mysqli_stmt_bind_param($stmt, "ss", $user_name, $user_pass);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);

    if (mysqli_num_rows($result) > 0) {
        echo 'Authentifier avec succès';
    } else {
        echo 'Numéro ou mot de passe incorrecte';
    }
}    
?>