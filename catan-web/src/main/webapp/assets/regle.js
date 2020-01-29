

function lanceDe() {
	alert(Math.floor(Math.random()*5 + Math.random()*5 + 2));
//	let colDelete = document.createElement('td');
//	let btnLanceDe = document.createElement('button');
//	row.append(colDelete);
//	document.querySelector('tbody').prepend(row);
//	colNom.innerHTML = produit.libelle;
//	colPrix.innerHTML = produit.prix + " euros";
//	colDelete.append(btnDelete);
//	
//	btnDelete.innerHTML = "Supprimer";
//	btnDelete.classList.add('btn','btn-danger');
//	
//	btnDelete.addEventListener('click', () => {
//		fetch('http://172.16.44.107:8081/E-musique-web/api/produit/listeProduits${ produit.id }', {
//		method: 'DELETE',
//		}).then(resp => {row.remove();});
//	})
}


//<button id="lanceDe" type="button" class="btn btn-secondary btn-lg" >Lancer les des</button>

function desactive_bouton()
{
 
	document.getElementById('lanceDe').disabled=true;
//	document.getElementById('lanceDe').innerHTML='vous ne pouvez plus tirer';
	
}

document.querySelector('#lanceDe')
		.addEventListener('click', (event) =>{
			lanceDe();
			desactive_bouton();
//			var button = document.getElementById("#lanceDe");
//			button = "Fin de tour";    
		
		});
