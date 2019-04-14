$( document ).ready(function() {
	$("#list").change(function(){
		var fileName = $('#list').val();
		$.post("generic.php", {param1 : fileName}, function(data, status){
			if (fileName == "files/cdcatalog.xml") {
				displayCDs(fileName, data);
			} else if (fileName == "files/plants.xml") {
				displayPlants(fileName, data);
			}
		}).done(function(){
			alert("data was returned correctly");
		}).fail(function(status) {
			alert("there was an error. The page came back with a status of: " + status);
		}).always(function() {
			alert("The page continues on as normal");
		});
		
		function displayCDs(fileName, data) {
			var item = data.getElementsByTagName("cd");
			$("#output").text("");
			if (item.length > 0) {
				for (var i = 0 ; i < item.length ; ++i) {
					var title = item[i].getElementsByTagName("title")[0].childNodes[0].nodeValue;
					var artist = item[i].getElementsByTagName("artist")[0].childNodes[0].nodeValue;
					var country = item[i].getElementsByTagName("country")[0].childNodes[0].nodeValue;
					var company = item[i].getElementsByTagName("company")[0].childNodes[0].nodeValue;
					var price = item[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
					var year = item[i].getElementsByTagName("year")[0].childNodes[0].nodeValue;
					
					var cd = "<p>Title: " + title + "</p>"
							+ "<p>Artist: " + artist + "</p>"
							+ "<p>Country: " + country + "</p>"
							+ "<p>Company: " + company + "</p>"
							+ "<p>Price: $" + price + "</p>"
							+ "<p>Year: " + year + "</p>";
							
					$("#output").append(cd + "<br /><hr />");
				}
			}
		}
				
		function displayPlants(fileName, data) {
			var item = data.getElementsByTagName("plant");
			$("#output").text("");
			if (item.length > 0) {
				for (var i = 0 ; i < item.length ; ++i) {
					var common = item[i].getElementsByTagName("common")[0].childNodes[0].nodeValue;
					var botanical = item[i].getElementsByTagName("botanical")[0].childNodes[0].nodeValue;
					var zone = item[i].getElementsByTagName("zone")[0].childNodes[0].nodeValue;
					var light = item[i].getElementsByTagName("light")[0].childNodes[0].nodeValue;
					var price = item[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
					var availability = item[i].getElementsByTagName("availability")[0].childNodes[0].nodeValue;
					
					var plant = "<p>Name: " + common + "</p>"
							+ "<p>Latin name: " + botanical + "</p>"
							+ "<p>zone: " + zone + "</p>"
							+ "<p>light required: " + light + "</p>"
							+ "<p>Price: " + price + "</p>"
							+ "<p>availability: " + availability + "</p>";
						
					$("#output").append(plant + "<br /><hr />");
				}
			}
		}
	});
});