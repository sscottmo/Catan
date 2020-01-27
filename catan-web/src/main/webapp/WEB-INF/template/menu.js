function ajouterUtilisateur(pseudo, statut, event) {
	// Creation des elements du tableau
	let row = document.createElement('tr');
	let colPseudo = document.createElement('td');
	let colStatut = document.createElement('td');
	
	//On ajoute les TD au TR
	row.append(colPseudo);
	row.append(colStatut);

	// On ajoute la ligne au tableau
	document.querySelector('tbody').append(row);
	
	// On ajoute les informations
	colPseudo.innerHTML = pseudo;
	colStatut.innerHTML = statut;
	
}


function afficherUtilisateurs(listUtilisateur) {
	fetch("http://localhost:8080/catan-html/menu.html")
//		.then(resp => resp.json())
		.then(utilisateurs => {
			listUtilisateur.forEach( u => {
				ajouterUtilisateur(u.nom, u.statut);
			});
		});
}

//import { listUtilisateur, ajoutUtilisateur } from './accueil.js';
//
//console.log(listUtilisateur);

const ajoutUtilisateur = (Utilisateur, listUtilisateur) => {
	listUtilisateur.push(Utilisateur);
}
let listUtilisateur = [];
let Utilisateur = {
		nom: "maxou",
		motDePasse: "password",
		mail: "haha@hotmail.fr",
		statut: "déconnecté"
}
ajoutUtilisateur(Utilisateur, listUtilisateur);
Utilisateur = {
		nom: "sisilas",
		motDePasse: "password2",
		mail: "gngngn@gmail.com",
		statut: "déconnecté"
}
ajoutUtilisateur(Utilisateur, listUtilisateur);

afficherUtilisateurs(listUtilisateur);