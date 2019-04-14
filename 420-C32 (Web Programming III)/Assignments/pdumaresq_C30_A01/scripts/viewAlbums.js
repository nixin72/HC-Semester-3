$( document ).ready(function() {
	console.log("reading JS file");
	
	$(".list").change(function(){
		var genre = $(".list").val();
		console.log(genre);
		$.get("getAlbums.php?genre="+genre, function(data, status){
			displayAlbums(data);
		});
		
		function displayAlbums(data) {
			console.log("inside function");
			var item = data.getElementsByTagName("album");
			$("#output").text("");
			if (item.length > 0) {
				for (var i = 0 ; i < item.length ; ++i) {
					var albumName = item[i].getElementsByTagName("albumName")[0].childNodes[0].nodeValue;
					var artist = item[i].getElementsByTagName("artist")[0].childNodes[0].nodeValue;
					var company = item[i].getElementsByTagName("company")[0].childNodes[0].nodeValue;
					var condition = item[i].getElementsByTagName("condition")[0].childNodes[0].nodeValue;
					var year = item[i].getElementsByTagName("year")[0].childNodes[0].nodeValue;
					var price = item[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;
					
					var album = "<p>Title: " + albumName + "</p>"
							+ "<p>Artist: " + artist + "</p>"
							+ "<p>Country: " + company + "</p>"
							+ "<p>Company: " + condition + "</p>"
							+ "<p>year: " + year + "</p>"
							+ "<p>Price: " + price + "</p>";
							
					$("#output").append("<br />" + album + "<br /><hr></hr>");
				}
				$("hr:last").empty();
			}
			
		}
	});
});