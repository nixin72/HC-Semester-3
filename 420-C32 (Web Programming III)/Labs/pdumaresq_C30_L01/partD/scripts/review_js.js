function checkThis() {
	var allValid = true;
	var inputId = ["field1", "field2", "field3"];
	for ( var q = 0 ; q < inputId.length ; q++) {
		var value = document.getElementById(inputId[q]).value;
		if (value == "") {
			allValid = false;
		}
	}
	if (allValid == false) {
		alert("Please fill in all fields");
	}
	return allValid;
}

function formIsValid(event) {
	if (!checkThis()) { 
		document.getElementById("body").style.backgroundColor = "#CCC"; 
		event.preventDefault();
	}
}
document.getElementById("button").addEventListener("click", formIsValid);