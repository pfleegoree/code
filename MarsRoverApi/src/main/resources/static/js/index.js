let userId = getUrlParameter('userId')
if (userId == null || userId == '') {
	userId = localStorage.getItem('userId')
}

if (userId != null && userId != '') {
	localStorage.setItem('userId', userId)
	document.getElementById('userId').value = userId
}

let marsApiButtons = document.querySelectorAll("button[id*='marsApi']")

marsApiButtons.forEach(button => button.addEventListener('click', function() {
	const buttonId = this.id
	const roverId = buttonId.split('marsApi')[1]
	let apiData = document.getElementById('marsApiRoverData')
	apiData.value = roverId
	document.getElementById('frmRoverType').submit()
}))



let marsRoverType = document.getElementById('marsApiRoverData').value
		
highlightBtnByRoverType(marsRoverType)

let marsSol = document.getElementById('marsSol').value


if (marsSol !=null && marsSol != '' && marsSol >= 0)
document.getElementById('marsSol').value = marsSol

function highlightBtnByRoverType (roverType) {
	if (roverType == '') 
		roverType = 'Opportunity'
	
	document.getElementById('marsApi'+roverType).classList.remove('btn-secondary')
	document.getElementById('marsApi'+roverType).classList.add('btn-primary')
}