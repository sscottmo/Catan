
const hideSections = () => {
	document.querySelectorAll('section')
		.forEach((section) => {
			section.style.display='none';
		});
}

const showOneSection = (idSection) => {
	document.querySelectorAll('section')
		.forEach((section) => {
			if (section.id == idSection) {
				section.style.display='block';
			}
		});
}

hideSections();
showOneSection("connexion");

document.querySelectorAll('form a')
		.forEach(lien => {
			lien.addEventListener('click', (event) => {
				console.log(event);
				event.preventDefault();
				hideSections();
				
				let sectionId = event.target.getAttribute('href');
				
				document.querySelector(sectionId)
						.style.display = 'block';
			});
		});



const tryConnexion = (utilisateurs) => {
	return new Promise((resolve, reject) => {
		document.querySelector('button').addEventListener('click', () => {
			utilisateurs.forEach(utilisateur => {
				pseudo = document.querySelector('input[name="pseudo"]').value;
				password = document.querySelector('input[name="password"]').value;
				if ((utilisateur.nom == pseudo) && (utilisateur.motDePasse == password)) {
					resolve("Connexion réussie");
				} else {
					reject("Erreur lors de l'authentification, veuillez recommencer");
				}
			});
		});
	});
}

listUtilisateur


tryConnexion(listUtilisateur);




function seConnecter(event) {
	event.preventDefault();
	// On ajoute les informations
	colNom.innerHTML = document.querySelector('input[name="libelle"]').value;
	colPrix.innerHTML = document.querySelector('input[name="prix"]').value;
	
}


let myLink = document.querySelector('form')
				.addEventListener('button', ajouterProduit);


