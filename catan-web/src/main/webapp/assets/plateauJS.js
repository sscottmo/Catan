

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


eventSource.addEventListener('message',(event)=>{

	
	let object = JSON.parse(event.data);
	let id= '#cr_'+ object[0];
	let couleur = object[1];
	ajouteCroisement(id, couleur);
})


//Chemins


for (i=1 ; i<73 ; i++) {
	let j = i;
	let idChem = '#ch_'+ i.toString();
	document.querySelector(idChem)
			.addEventListener('click', (event) => {
				let data ={
						"id": j
						};

				modifierCheminAjax(data);
				});
}


function modifierCheminAjax(data) {
	
	
	let idRecu = fetch('http://localhost:8080/catan-web/api/chemin',{
		method: 'POST',
		headers:{
			'Content-Type': 'application/json'
				},
		body: JSON.stringify(data)
	}).then(resp => resp.json());
}


let eventSource2 = new EventSource('http://localhost:8080/catan-web/api/chemin/sse');


eventSource2.addEventListener('message',(event)=>{

	
	let object = JSON.parse(event.data);
	let id= '#ch_'+ object[0];
	let couleur = object[1];
	ajouteChemin(id, couleur);
})

function ajouteChemin(id,couleur) {
	document.querySelector(id)
			.style.backgroundColor=couleur;
}