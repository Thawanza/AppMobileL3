php suppression


<?php
 
/*
 Requête HTTP POST 
 */
 
// Tableau de réponse JSON (array)
$reponse = array();
 
// Vérifier s'il y a une donnée reçue
if (isset($_POST['nom'])) {
    $valeur_col1 = $_POST['nom'];

    // Connexion à la base de données
    require_once 'connec.php';
 
    // Supprimer la ligne
    $req = "DELETE FROM planningvaccination WHERE nomvaccin = ?";
    $stmt = $pdo->prepare($req);
    $stmt->execute([$valeur_col1]);
 
    // Vérifier si la ligne est supprimée ou non
    if ($stmt->rowCount() > 0) {
        // Ligne supprimée
        $reponse["success"] = 1;
        $reponse["message"] = "Vaccin supprimée";
        echo json_encode($reponse);
    } else {
        // Ligne n'existe pas avec col1 = col1 (reçue)
        $reponse["success"] = 0;
        $reponse["message"] = "Erreur de suppression";
        echo json_encode($reponse);
    }
} else {
    // Champ manquant col1
    $reponse["success"] = 0;
    $reponse["message"] = "Champ manquant";
    echo json_encode($reponse);
}
?>
