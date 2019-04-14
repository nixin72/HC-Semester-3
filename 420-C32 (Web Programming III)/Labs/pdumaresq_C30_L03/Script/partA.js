function getServerTime() {
	console.log("function getting called");
	var request = false;
	
	try {
		var request = new XMLHttpRequest();
	} catch(e) {
		console.log("couldn't make new XMLHttpRequest");
	}
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = request.responseText;
			document.getElementById("time").innerHTML = response;
		}
	};
	
	request.open("GET", "php/servertime.php", true);
	request.send();
}

document.getElementById("fN").addEventListener("onkeyup", getServerTime);
document.getElementById("lN").addEventListener("onkeyup", getServerTime);