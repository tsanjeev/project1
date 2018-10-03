/**
 * 
 */




function eventHandler(){
	
	event.preventDefault();
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let responseText = xhr.responseText;
			console.log(responseText);
			var json = JSON.parse(responseText);
			console.log(json);
			document.getElementById("welcome-text").innerText = "Welcome: "+ json[0].firstName + " " + json[0].lastName;
			document.getElementById("title-pos").innerText = json[0].title + " - " + json[0].department;
			
			var table = document.getElementById("rforms-body");
			for (var i = 1; i < json.length; i++){
				var row = document.createElement("tr");
			    var dataFormID = document.createElement("td");
				dataFormID.innerHTML = json[i].formID;
				row.append(dataFormID);
				
				var dataEID = document.createElement("td");
				dataEID.innerHTML = json[i].employeeID;
				row.append(dataEID);
				
				var fname = document.createElement("td");
				fname.innerHTML = json[i].firstname;
				row.append(fname);
				
				var lname = document.createElement("td");
				lname.innerHTML = json[i].lastname;
				row.append(lname);
				
				var loc = document.createElement("td");
				loc.innerHTML = json[i].location;
				row.append(loc);
				
				var city = document.createElement("td");
				city.innerHTML = json[i].city;
				row.append(city);
				
				var state = document.createElement("td");
				state.innerHTML = json[i].state;
				row.append(state);
				
				var zip = document.createElement("td");
				zip.innerHTML = json[i].zip;
				row.append(zip);
				
				var desc = document.createElement("td");
				desc.innerHTML = json[i].description;
				row.append(desc);
				
				var stat = document.createElement("td");
				stat.innerHTML = json[i].status;
				row.append(stat);
				
				var cDate = document.createElement("td");
				var nDate = new Date(json[i].currDate);
				var d = nDate.getDay() + 1;
				var m = nDate.getMonth() + 1;
				var y = nDate.getFullYear();
				cDate.innerHTML = m + "/" + d + "/" + y;
				row.append(cDate);
				
				var sDate = document.createElement("td");
				var newDate = new Date(json[i].startDate);
				var day = newDate.getDay() + 1;
				var month = newDate.getMonth() + 1;
				var year = newDate.getFullYear();
				sDate.innerHTML= month + "/" + day + "/" + year;
				row.append(sDate);
				
				var t = document.createElement("td");
				t.innerHTML = json[i].time;
				row.append(t);
				
				var score = document.createElement("td");
				score.innerHTML = json[i].grade;
				row.append(score);
				
				var event = document.createElement("td");
				event.innerHTML = json[i].eventType;
				row.append(event);
				
				var just = document.createElement("td");
				just.innerHTML = json[i].justification;
				row.append(just);
				
				
				
				
				var c = document.createElement("td");
				c.innerHTML = json[i].cost;
				row.append(c);
				
				var p = document.createElement("td");
				p.innerHTML = json[i].projected;
				row.append(p);
					
			
					var apptd = document.createElement("td");
					var approve = document.createElement("a");
					approve.setAttribute("href","approve?" + json[i].formID);
					approve.setAttribute("name", json[i].formID);
					approve.setAttribute("value", 3);
					approve.innerHTML = "Approve";
					apptd.append(approve);
					//row.append(apptd);
					
					var deny = document.createElement("a");
					var denytd = document.createElement("td");
					deny.setAttribute("href","deny?" + json[i].formID);
					deny.setAttribute("name", json[i].formID);
					deny.innerHTML = "Deny";
					//denytd.append(deny);
					var br = document.createElement("br");
					apptd.append(br);
					apptd.append(deny);
					//row.append(denytd);
					row.append(apptd);
					table.append(row);
				  }
		}
		
	}
	xhr.open("GET", "pending", true);
	xhr.send();
	
}

window.onload = function(){
	//document.getElementById("getInfo").addEventListener("click", eventHandler);
	eventHandler();
}