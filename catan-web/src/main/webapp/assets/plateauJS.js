

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

//
// document.querySelectorAll('.dropdown')
// .forEach(lien => {
// lien.addEventListener('click', (event) => {
// console.log(event);
// event.preventDefault();
// hideSections();
//		
// let sectionId = event.target.getAttribute('href');
//		
// document.querySelector(sectionId)
// .style.display = 'block';
// });
// });
//


let eventSource = new EventSource('http://localhost:8080/catan-web/api/plateau/sse');


eventSource.addEventListener('croisement',(event)=>{
//	//Si on reçoit un string
//	  let msg = event.data;
//	  alert(msg);
//	  
//	  //Si on a reçu un object json
//	  let object = JSON.parse(event.data);
//	  console.log(object);
	let croisement = JSON.parse(event.data);
	saveCroisement(croisement);
})