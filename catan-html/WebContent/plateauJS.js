

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