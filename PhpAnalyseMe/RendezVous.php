<?php
// Tableau de réponse JSON (array)
$reponse = array();

// Tester si les champs sont valides
if (!empty($_POST['nu']) && !empty($_POST['typ']) && !empty($_POST['adre']) && !empty($_POST['dat']) && !empty($_POST['heu']) && !empty($_POST['depl'])) {
    $valeur_col1 = $_POST['nu'];
    $valeur_col2 = $_POST['depl'];
    $valeur_col3 = $_POST['typ'];
    $valeur_col4 = $_POST['dat'];
    $valeur_col5 = $_POST['heu'];
    $valeur_col6 = $_POST['adre'];

    // Inclure la classe de connexion
    // require_once __DIR__ . '/connexion.php';
    $connexion = new PDO("mysql:host=localhost;dbname=analyzeme;", "root", "");

    // Requête pour vérifier la disponibilité de la date et de l'heure
    $stmt = $connexion->prepare("SELECT COUNT(*) as count FROM rendezvous WHERE daterdv = :date AND heurerdv = :heure");
    $stmt->bindParam(':date', $valeur_col4);
    $stmt->bindParam(':heure', $valeur_col5);
    $stmt->execute();

    // Récupérer le résultat
    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    $count = $result['count'];

    // Vérifier si la date et l'heure existent déjà
    if ($count > 0) {
        // Date et heure déjà réservées, renvoyer une réponse JSON avec le message approprié
        $reponse["success"] = 0;
        $reponse["message"] = "La date et l'heure sont déjà réservées. Veuillez choisir une autre date et heure.";
        echo json_encode($reponse);
        exit(); // Terminer l'exécution du script
    }

    // Requête pour insérer les données
    $resultat = $connexion->exec("INSERT INTO rendezvous(nomuser,typeprelevement, listeanalyse,  daterdv, heurerdv, adresse) VALUES('$valeur_col1', '$valeur_col2', '$valeur_col3', '$valeur_col4','$valeur_col5','$valeur_col6')");

    // Tester si les données sont bien insérées
    if ($resultat) {
        // Données bien insérées
        $reponse["success"] = 1;
        $reponse["message"] = "Données bien insérées";
        // Afficher la réponse JSON
        echo json_encode($reponse);
    } else {
        // Erreur d'insertion
        $reponse["success"] = 0;
        $reponse["message"] = "Oops! Erreur d'insertion.";
        // Afficher la réponse JSON
        echo json_encode($reponse);
    }
} else {
    // Champ(s) manquant(s)
    $reponse["success"] = 0;
    $reponse["message"] = "Champ(s) manquant(s)";
    if (empty($_POST['nu']) && empty($_POST['typ']) && empty($_POST['adre']) && empty($_POST['dat']) && empty($_POST['heu']) && empty($_POST['depl'])) {
        $reponse["success"] = 0;
        $reponse["message"] = "Champ(s) manquant(s)";
    }
    //
    echo json_encode($reponse);
    exit();
}
?>
