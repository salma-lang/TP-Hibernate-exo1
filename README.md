##   Exercice 1: Gestion de produits avec Hibernate

## 1. Prérequis
Pour exécuter ce projet, vous devez installer les outils suivants :


IDE Java (Netbeans)

XAMPP 


## 2. Création du projet Java
Commencez par créer un nouveau projet Java dans votre IDE préféré et nommez-le H1. Dans ce projet, vous allez devoir ajouter les bibliothèques suivantes :

-Hibernate ORM pour la gestion des objets relationnels.

-Le pilote JDBC de MySQL pour la connexion à la base de données MySQL.


## 3. Création de la base de données
Lancez XAMPP et démarrez le serveur MySQL. Ensuite, créez une base de données nommée H1 dans MySQL.

## 4. Création de l’entité Produit
Dans le package ma.projet.entity, créez une classe Produit. Cette classe représentera un produit dans la base de données et sera mappée à une table via l'annotation @Entity. Les attributs de la classe sont :

-marque : La marque du produit.

-reference : La référence du produit.

-dateAchat : La date d'achat du produit.

-prix : Le prix du produit.

-designation : La désignation ou description du produit.


## 5. Configuration d'Hibernate
Créez un fichier de configuration hibernate.cfg.xml dans le package ma.projet.config. Ce fichier contiendra les informations de connexion à la base de données (URL, nom d'utilisateur, mot de passe), ainsi que les paramètres de Hibernate tels que le dialecte MySQL.

## 6. Utilitaire Hibernate
Dans le package ma.projet.util, créez une classe nommée HibernateUtil. Cette classe est utilisée pour initialiser et obtenir une instance de SessionFactory, essentielle pour interagir avec la base de données. Le bloc statique de cette classe permet de gérer la configuration Hibernate.

## 7. Interface DAO
Dans le package ma.projet.dao, définissez une interface générique IDao<T>. Cette interface contiendra les méthodes standards pour effectuer des opérations CRUD (Create, Read, Update, Delete) sur les entités.

## 8. Service Produit
Dans le package ma.projet.service, implémentez une classe ProduitService qui fournira des méthodes pour gérer les entités Produit. Cette classe appellera les méthodes définies dans l'interface IDao pour créer, lire, mettre à jour et supprimer des produits.

## 9. Tester le projet
Dans la classe de test, utilisez ProduitService pour créer plusieurs produits, les afficher, en supprimer un et effectuer des requêtes spécifiques, comme afficher les produits dont le prix est supérieur à 100 DH.


