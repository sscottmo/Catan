

const afficherMenu = (event) => {
	document.querySelectorAll('.dropdown-content')
		.forEach((section) => {
			{
				if (section.style.display=='none'){
					section.style.display='inline-block';
				}
				else {
					section.style.display='none';
				}
			}
		});
}


document.querySelector('.dropdown')
.addEventListener('click', (event) =>{
	afficherMenu();
});



function modifierCroisementAjax(data) {
	
	
	let idRecu = fetch('http://localhost:8080/catan-web/api/plateau',{
		method: 'POST',
		headers:{
			'Content-Type': 'application/json'
				},
		body: JSON.stringify(data)
	}).then(resp => resp.json());
}



function ajouteCroisement(id,couleur) {
	document.querySelector(id)
			.style.backgroundColor=couleur;
}

for (i=1 ; i<55 ; i++) {
	let j = i;
	let idCrois = '#cr_'+ i.toString();
	document.querySelector(idCrois)
			.addEventListener('click', (event) => {
				let data ={
						"id": j
						};

				modifierCroisementAjax(data);
				});
}


let eventSource = new EventSource('http://localhost:8080/catan-web/api/plateau/sse');


eventSource.addEventListener('croisement',(event)=>{
// //Si on reçoit un string
// let msg = event.data;
// alert(msg);
//	  
// //Si on a reçu un object json
// let object = JSON.parse(event.data);
// console.log(object);
	let croisement = JSON.parse(event.data);
	let id= '#cr_'+ croisement.id;
	let couleur = croisement.couleur
	
	ajouteCroisement(id, couleur);
})