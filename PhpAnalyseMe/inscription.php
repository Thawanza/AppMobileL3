<?php
/*
 Requête HTTP Post 
 */
// tableau de réponse JSON (array)
$reponse = array();
// tester si les champs sont valides
if (!empty($_POST['etnum']) && !empty($_POST['etuser']) && !empty($_POST['etmdp'])&& !empty($_POST['etage'])&& !empty($_POST['spsexe'])) {
    $valeur_col2 = $_POST['etnum'];
    $valeur_col3 = $_POST['etuser'];
    $valeur_col4 = $_POST['etmdp'];
    $valeur_col5 = $_POST['etage'];
    $valeur_col6 = $_POST['spsexe'];
    // inclure la classe de connexion
    // require_once __DIR__ . '/connexion.php';
    $connexion =new PDO("mysql:host=localhost;dbname=analyzeme;","root","");
    // connxion à la base
    // $db = new CONNEXION_DB ();
    // requéte pour insérer les données
    $resultat =  $connexion->exec("INSERT INTO patient(numerodetelephone, user, motdepasse, age, sexe) VALUES('$valeur_col2', '$valeur_col3', '$valeur_col4','$valeur_col5','$valeur_col6')");
    // tester si les données sont bien insérées
    if ($resultat) {
        // Données bien insérées
        $reponse["success"] = 1;
        $reponse["message"] = "Données bien insérées";
       // afficher  la reponse JSON
        echo json_encode($reponse);
        exit();
    } else {
        // errur d'insertion
        $reponse["success"] = 0;
        $reponse["message"] = "Oops! Erreur d'insrtion.";
      // afficher  la réponse JSON
        echo json_encode($reponse);
        exit();
    } 
}   
else {
        // Champ(s) manquant(s)
        $reponse["success"] = 0;
        $reponse["message"] = "Champ(s) manquant(s)";
    
        if (empty($_POST['etnum'])||empty($_POST['etuser'])||empty($_POST['etmdp'])||empty($_POST['etage'])||empty($_POST['spsexe'])) {
            $reponse["success"] = 0;
            $reponse["message"] = "Champ(s) manquant(s)";
        }
        // if (empty($_POST['etuser'])) {
        //     $errorMessages. .= " Le champ 'etuser' est manquant.";
        // }
        // if (empty($_POST['etmdp'])) {
        //     $errorMessages .= " Le champ 'etmdp' est manquant.";
        // }
        // if (empty($_POST['etage'])) {
        //     $errorMessages.= " Le champ 'etage' est manquant.";
        // }
        // if (empty($_POST['spsexe'])) {
        //     $errorMessages.= " Le champ 'spsexe' est manquant.";
        // }
  
        // afficher la réponse JSON
        echo json_encode($reponse);
        exit();
}
       
// } else {
//     // Champ(s) manquant(s)
//     $reponse["success"] = 0;
//     $reponse["message"] = "Champ(s) manquant(s)";
//     // afficher  la réponse JSON
//     echo json_encode($reponse);
// }
?>




