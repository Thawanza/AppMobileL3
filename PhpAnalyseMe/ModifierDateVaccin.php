<?php
 
/*
 Requête HTTP POST 
 */
 
// Tableau de réponse JSON (array)
$reponse = array();
 
// Vérifier s'il y a une donnée reçue
if (isset($_POST['nom']) && isset($_POST['date'])) {
    $valeur_col1 = $_POST['nom'];
    $valeur_col2 = $_POST['date'];

    // Connexion à la base de données
    require_once 'connec.php';
 
    // Supprimer la ligne
    $req = "UPDATE `planningvaccination` SET `datevaccin`= ? WHERE nomvaccin = ?";
    $stmt = $pdo->prepare($req);
    $stmt->execute([$valeur_col2, $valeur_col1]);
 
    // Vérifier si la ligne est mise à jour ou non
    if ($stmt->rowCount() > 0) {
        // Ligne mise à jour
        $reponse["success"] = 1;
        $reponse["message"] = "Modifie avec succès";
        echo json_encode($reponse);
    } else {
        // Ligne n'existe pas avec col1 = col1 (reçue)
        $reponse["success"] = 0;
        $reponse["message"] = "Erreur de modification";
        echo json_encode($reponse);
    }
} else {
    // Champ manquant col1 ou col2
    $reponse["success"] = 0;
    $reponse["message"] = "Champ manquant";
    echo json_encode($reponse);
}
?>
