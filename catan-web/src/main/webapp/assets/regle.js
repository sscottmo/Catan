

function lanceDe() {
	alert(Math.floor(Math.random()*5 + Math.random()*5 + 2));
}

function desactive_bouton()
{
 
	document.getElementById('lanceDe').value="Fin de tour";
	document.getElementById('lanceDe').style.display="none";
	
}

document.getElementById('findetour').style.display="none";
document.querySelector('#lanceDe')
		.addEventListener('click', (event) =>{
			lanceDe();
			desactive_bouton();   
			document.getElementById('findetour').style.display="block";
		});


document.querySelector('#findetour')
		.addEventListener('click', (event) =>{
			alert("yes");
			desactive_bouton();   
		
		});


//[[${sessionJoueur.bois}]]

