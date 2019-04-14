function buttonClick() {
	if (document.getElementById("button").getAttribute("value") == "start") {
		document.getElementById("button").setAttribute("value", "stop");
		interval = setInterval(doStuff, 3000);
	}
	else {
		clearInterval(interval);
	}
}

function doStuff() {
	try {
		var request = new XMLHttpRequest();
	} catch(e) {
		console.log("couldn't make new XMLHttpRequest");
	}
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = request.responseText;
			var id;
			if (response != "Vann") {
				var lastChar = response[response.length-1];
				var lastIndex = response.indexOf(lastChar);
				id = response.substring(0, lastIndex-1);
			} else {
				id = response;
			}
			
			var el = document.getElementById(id);
			var content = el.textContent;
			content = parseInt(content) + 1;
			
			el.textContent = content;
		}
	};
	
	request.open("GET", "php/random.php", true);
	request.send();
}
document.getElementById("button").addEventListener("click", buttonClick);