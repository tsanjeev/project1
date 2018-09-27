/**
 * 
 */


function makeUser(firstname, lastname, username, password, title, dept){
	let user = {};
	user.firstName = firstname;
	user.lastName = lastname;
	user.userName = username;
	user.passWord = password;
	user.title = title;
	user.department = dept;
	return user;
}

function handleEvent(){
	
	let xhr = new XMLHttpRequest();
	
	let firstname = document.getElementById("firstname").value;
	let lastname = document.getElementById("lastname").value;
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let position = document.getElementById("position").value;
	let department = document.getElementById("department").value;

	let user = makeUser(firstname, lastname, username, password, position, department);
	
	
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
		}
		
	}
	xhr.open("POST", "signup", true);
	xhr.send(JSON.stringify(user));
	
}

window.onload = function(){
	document.getElementById("signup-submit").addEventListener("click", handleEvent);
}