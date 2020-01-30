

function lanceDe() {
	alert(Math.floor(Math.random()*5 + Math.random()*5 + 2));
}

function desactive_bouton() {
 
	document.getElementById('lanceDe').value="Fin de tour";
	document.getElementById('lanceDe').style.display="none";
	document.getElementById('findetour').style.display="block";
	
}

document.getElementById('findetour').style.display="none";
document.querySelector('#lanceDe')
		.addEventListener('click', (event) =>{
			lanceDe();
			desactive_bouton();   
		});

function ajouteCroisement(id,couleur) {
	document.querySelector(id)
			.style.backgroundColor=couleur;
}

//for (i=1 ; i<55 ; i++) {
//	let id = '#cr_'+ i.toString();
//	document.querySelector(id)
//			.addEventListener('click', (event) => {
//				ajouteCroisment()
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


let eventSource = new EventSource('http://172.16.44.102:8080/catan-web/api/plateau/sse');

eventSource.addEventListener('message', (croisement,couleur) => {
	
	let produit = {
			libelle: event.data,
			prix: 0
	};
	afficheProduitURL(produit);
	
})
