//
//const hideSections = () => {
//	document.querySelectorAll('section')
//		.forEach((section) => {
//			section.style.display='none';
//		});
//}
//
//const showOneSection = (idSection) => {
//	document.querySelectorAll('section')
//		.forEach((section) => {
//			if (section.id == idSection) {
//				section.style.display='block';
//			}
//		});
//}
//
//hideSections();
//showOneSection("inscription");
//
//document.querySelectorAll('form a')
//		.forEach(lien => {
//			lien.addEventListener('click', (event) => {
//				console.log(event);
//				event.preventDefault();
//				hideSections();
//				
//				let sectionId = event.target.getAttribute('href');
//				
//				document.querySelector(sectionId)
//						.style.display = 'block';
//			});
//		});
//
//
//export const ajoutUtilisateur = (Utilisateur, listUtilisateur) => {
//	listUtilisateur.push(Utilisateur);
//}
//
//export let listUtilisateur = [];
//let Utilisateur = {
//		nom: "maxou",
//		motDePasse: "password",
//		mail: "haha@hotmail.fr",
//		statut: "connecté"
//}
//ajoutUtilisateur(Utilisateur, listUtilisateur);
//Utilisateur = {
//		nom: "sisilas",
//		motDePasse: "password2",
//		mail: "gngngn@gmail.com",
//		statut: "connecté"
//}
//ajoutUtilisateur(Utilisateur, listUtilisateur);
//
////export { Utilisateur, listUtilisateur, ajoutUtilisateur };
//
//console.log(listUtilisateur);
//
//const tryConnexion = (listUtilisateur) => {
//	return new Promise((resolve, reject) => {
//		document.querySelector('button[name="buttonC"]').addEventListener('click', () => {
//			listUtilisateur.forEach(utilisateur => {
//				let pseudo = document.querySelector('input[name="pseudoC"]').value;
//				let password = document.querySelector('input[name="passwordC"]').value;
//				if ((utilisateur.nom == pseudo) && (utilisateur.motDePasse == password)) {
//					resolve("Connexion réussie");
//				} else {
//					reject("Erreur lors de l'authentification, veuillez recommencer");
//				}
//			});
//		});
//	});
//}
//
//
//
//const tryConnexionAsync = async (listUtilisateur) => {
//	try {
//		let resultatRequete = await tryConnexion(listUtilisateur);
//		document.location.href="http://localhost:8080/catan-html/menu.html";
//	}
//	catch (e) {
//		document.location.href="http://localhost:8080/catan-html/accueil.html";
//		alert("Erreur lors de l'authentification")
//		console.error(e)
//	}
//	//...
//}
//
//
//document.querySelector('button[name="buttonC"]')
//			.addEventListener('click', tryConnexionAsync(listUtilisateur));
//
//
//
//const tryInscription = (listUtilisateur) => {
//	return new Promise((resolve, reject) => {
//		document.querySelector('button[name="buttonI"]').addEventListener('click', () => {
//			let utilisateurExiste = false;
//			let pseudo = document.querySelector('input[name="pseudoI"]').value;
//			let password = document.querySelector('input[name="passwordI"]').value;
//			let mail = document.querySelector('input[name="mail"]').value;
//			listUtilisateur.forEach(utilisateur => {
//				if (utilisateur.nom === pseudo) {
//					utilisateurExiste = true;
//					reject("pseudo déjà utilisé");
//				}
//				if (password.length <= 6) {
//					reject("Mot de passe de moins de 6 caractères");
//				}
//			});
//			if (utilisateurExiste == false) {
//				let Utilisateur = {
//					pseudo: pseudo,
//					password: password,
//					mail: mail	
//				}
//				ajoutUtilisateur(Utilisateur, listUtilisateur);
//				resolve("Création du nouvel utilisateur");
//			}
//		});
//	});
//}
//
//
//
//const tryInscriptionAsync = async (listUtilisateur) => {
//	try {
//		let resultatRequete = await tryInscription(listUtilisateur);
//		console.log(resultatRequete);
//		document.location.href="http://localhost:8080/catan-html/menu.html";
//		alert(listUtilisateur)
//	}
//	catch (e) {
//		alert("Erreur lors de l'inscription")
//		console.error(e)
//	}
//}
//
//document.querySelector('button[name="buttonI"]')
//				.addEventListener('click', tryInscriptionAsync(listUtilisateur));
//
//
