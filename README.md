# Application mobile Java L3
Application Mobile de Gestion de Laboratoire Médical

            Description générale
Ce projet est une application mobile complète développée dans le cadre de notre troisième année de licence (L3).
Elle vise à faciliter la gestion des analyses médicales entre les patients et les administrateurs du laboratoire grâce à deux applications Android connectées à un backend PHP et une base de données MySQL.

           Structure du projet
   1. ZinalAnalyseMe

Application mobile destinée aux patients.

Cette partie du projet permet aux patients de :

Créer un compte et se connecter à l’application.

Prendre rendez-vous en ligne pour leurs tests de laboratoire.

Consulter les types d’analyses disponibles et leurs coûts.

Accéder à leurs résultats une fois publiés par le laboratoire.

            
             2. AdminA

Application mobile réservée aux gestionnaires (administrateurs du laboratoire).

Cette partie est utilisée par le personnel du laboratoire pour :

Consulter les rendez-vous pris par les patients.

Gérer les plannings des vaccinations.

Publier les résultats d’analyses sur la plateforme.




        3. PhpAnalyseMe

Dossier contenant le backend (partie serveur) développé en PHP.

Cette partie gère la connexion entre les deux applications mobiles et la base de données MySQL.
Elle contient les fichiers PHP responsables de :

L’authentification des utilisateurs (patients et administrateurs).

L’enregistrement et la récupération des rendez-vous.

La gestion et la publication des résultats médicaux.

La communication avec la base de données du laboratoire.

