<?php
// tableau de réponse JSON (array)
$reponse = array();
// tester si les champs sont valides
if (isset($_POST['etnomv']) && isset($_POST['etdatev'])) {
    $valeur_col1 = $_POST['etnomv'];
    $valeur_col2 = $_POST['etdatev'];
    // inclure la classe de connexion
    // require_once __DIR__ . '/connexion.php';
    $connexion =new PDO("mysql:host=localhost;dbname=analyzeme;","root","");
    // connxion à la base
    // $db = new CONNEXION_DB ();
    // requéte pour insérer les données
    $resultat =  $connexion->exec("INSERT INTO planningvaccination(nomvaccin, datevaccin) VALUES('$valeur_col1', '$valeur_col2')");
    // tester si les données sont bien insérées
    if ($resultat) {
        // Données bien insérées
        $reponse["success"] = 1;
        $reponse["message"] = "Données bien insérées";
       // afficher  la reponse JSON
        echo json_encode($reponse);
    } else {
        // errur d'insertion
        $reponse["success"] = 0;
        $reponse["message"] = "Oops! Erreur d'insrtion.";
      // afficher  la réponse JSON
        echo json_encode($reponse);
    }
} else {
    // Champ(s) manquant(s)
    $reponse["success"] = 0;
    $reponse["message"] = "Champ(s) manquant(s)";
    // afficher  la réponse JSON
    echo json_encode($reponse);
}
?>



?>
