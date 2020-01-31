

function lanceDe() {
	let res = Math.floor(Math.random()*5 + Math.random()*5 + 2);
	alert(res);
	return res;
}

function desactive_bouton() {
 
	document.getElementById('lanceDe').value="Fin de tour";
	document.getElementById('lanceDe').style.display="none";
	document.getElementById('findetour').style.display="block";
	
}

document.getElementById('findetour').style.display="none";
document.querySelector('#lanceDe')
		.addEventListener('click', (event) =>{
			desactive_bouton(); 
			envoieDe();
		});

function envoieDe() {
//	event.preventDefault();
	let resultatDe =lanceDe();
	let resDe ={
			"id": resultatDe
	};
	let de = fetch('http://localhost:8080/catan-web/api/plateau/de', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(resDe)
	}).then(resp => resp.json());
	
	console.log("coucou");
}

//const ajouterProduitURL = async (event) => {
//	event.preventDefault();
//	let produit = {
//			libelle: document.querySelector('input[name="libelle"]').value,
//			prix: document.querySelector('input[name="prix"]').value
//		};
//	
//	let produitRecu = await fetch('http://172.16.44.107:8081/E-musique-web/api/produit', {
//		method: 'POST',
//		headers: {
//			'Content-Type': 'application/json'
//		},
//		body: JSON.stringify(resultatDe)
//	}).then(resp => resp.json());
//	
//}


function ajouteCroisement(id,couleur) {
	document.querySelector(id)
			.style.backgroundColor='black';
}

//for (i=1 ; i<55 ; i++) {
//	let id = '#cr_'+ i.toString();
//	document.querySelector(id)
//			.addEventListener('click', (event) => {
////				ajouteCroisement();
//				document.querySelector(id).style.backgroundColor='black'
//				});
//}

var ad = 'http://localhost:8080/catan-web/plateau.html';
var req = new XMLHttpRequest();
	
//document.querySelector('p')
//		.addEventListener('click', (event) =>{
//			document.querySelector(this.getAttribute('id'))
//					.background-color('black')
//});

document.querySelector('#findetour')
		.addEventListener('click', (event) =>{
			alert("yes");
			desactive_bouton();   
		
		});


