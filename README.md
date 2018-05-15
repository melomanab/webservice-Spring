# webservice-Spring
Application J2EE utilisant le framework Spring pour implementer un WebService Jersey. 

## Description 
Cette application *expose* un savoir-faire **CRUDX** sur la classe domaine `Client.java`. 

## Pre-requis
- Cloner le repository GitHub en local sur la machine
- Importer l'application en Eclipse (import Maven)
- Rajouter la libraire Tomcat au BuildPath du projet
- Lancer le serveur de bdd WAMPP 
- Installer et lancer l'application Postman, qui fera le rôle de client web services (requêtes autres que GET)

## Utilisation
Pour consommer les web-services, il faut un **client** pour lancer les requêtes associées aux web-service.

### A. Utilisant le navigateur (Chrome) comme client
#### Lire la liste de clients (get all)
- Taper dans la barre de navigation l'url suivante:
http://localhost:8080/webservice_1.0/api/client
> Le navigateur envoi la chaîne JSON `[] ` qui veut dire que la bdd `WSbdd` créé lors du  lancement de l'application est vide

### B.  Utilisant Postman comme client
- Lancer l'application Postman
#### Créer un client (C - Create)
- *Verbe HTTP*: POST
- *URL*: http://localhost:8080/webservice_1.0/api/client
- Dans la section Body de la requête
	- Rentrer comme donnée la chaîne JSON suivante:
	```java
	{	
		"id": null,
		"nom": "Moreno",
		"prenom": "Beatriz"
	}
	```
	- Spécifier le format: "raw" "JSON(application/json)"
- Clicker sur le boutton *Send* pour lancer la requête
> RQ Status de la reponse HTTP: 200 OK

- Vérifier le corps de la réponse contient le flux JSON
> {
	    "id": 1,
	    "nom": "Moreno",
	    "prenom": "Beatriz"
}

>NOTE: Insérer autant de clients qu'on veut en répétant ces étapes

#### Lire un client (R - Read)
- *Verbe HTTP*: GET
- *URL*: http://localhost:8080/webservice_1.0/api/client/1
> RQ Status de la reponse HTTP: 200 OK

-  Vérifier que le corps de la reponse contient le flux JSON
> {
	    "id": 1,
	    "nom": "Moreno",
	    "prenom": "Beatriz"
}
#### Mettre à jour un client (U - Update)
- *Verbe HTTP*: PUT
- *URL*: http://localhost:8080/webservice_1.0/api/client/1
- Dans la section Body de la requête
	- Rentrer comme donnée la chaîne JSON suivante:
	```java
	{	
		"id": null,
		"nom": "Moreno Ortega",
		"prenom": "Beatriz"
	}
	```
	- Spécifier le format: "raw" "JSON(application/json)"
- Clicker sur le boutton *Send* pour lancer la requête
> RQ Status de la reponse HTTP: 200 OK
- Vérifier que le corps de la reponse contient le flux JSON
> {
	    "id": 1,
	    "nom": "Moreno Ortega",
	    "prenom": "Beatriz"
}

#### Supprimer un client (D - Delete)
- *Verbe HTTP*: DELETE
- *URL*: http://localhost:8080/webservice_1.0/api/client/1
> RQ. Le status de la reponse à cette requête: 204 No Content

#### Lire la liste de clients (X - Read All)
- Verbe HTTP: GET
- URL: http://localhost:8080/webservice_1.0/api/client
>Exemple de réponse HTTP:
>[
    {
        "id": 2,
        "nom": "Jackon",
        "prenom": "Michel"
    },
    {
        "id": 4,
        "nom": "Moreno Ortega",
        "prenom": "Beatriz"
    }
]









> Written with [StackEdit](https://stackedit.io/).
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQ1MjUzOTQ3NywtMTQyNzQ0NzgxNCwtNz
M1ODM4MjQ0LC0xNTExOTMwOTE5LDEyMTk2MjY4MjEsLTE2NzYz
NDQ2NzAsLTY3NDkxODc3NSwxMTcyMTU4NzAyLDgyNDc2NjQ1NV
19
-->