$( document ).ready(function() {
	$("#list").change(function(){
		$.get("StockCheck.php?checkQuote="+$('#list').val() , function(data, status){
			parse(data);
		}).done(function(){
			alert("data was returned correctly");
		}).fail(function(status) {
			alert("there was an error. The page came back with a status of: " + status);
		}).always(function() {
			alert("The page continues on as normal");
		});
		
		function parse(data) {
			console.log(data);
			var item = data.getElementsByTagName("quote");
			
			var ticker = item[0].getElementsByTagName("ticker")[0].childNodes[0].nodeValue;
			var lastTrade = item[0].getElementsByTagName("lastTrade")[0].childNodes[0].nodeValue;
			var lastTradeDate = item[0].getElementsByTagName("lastTradeDate")[0].childNodes[0].nodeValue;
			var lastTradeTime = item[0].getElementsByTagName("lastTradeTime")[0].childNodes[0].nodeValue;
			var change = item[0].getElementsByTagName("change")[0].childNodes[0].nodeValue;
			var open = item[0].getElementsByTagName("open")[0].childNodes[0].nodeValue;
			var rangeHigh = item[0].getElementsByTagName("rangeHigh")[0].childNodes[0].nodeValue;
			var rangeLow = item[0].getElementsByTagName("rangeLow")[0].childNodes[0].nodeValue;
			var volume = item[0].getElementsByTagName("volume")[0].childNodes[0].nodeValue;
			var chart = item[0].getElementsByTagName("chart")[0].childNodes[0].nodeValue;
				
			var company = $("#"+ticker).html();
			var allContent = "<p>Company: " + company + "</p>"
						+ "<p>last trade: " + lastTrade + "</p>"
						+ "<p>last trade date: " + lastTradeDate + "</p>"
						+ "<p>Last trade time: " + lastTradeTime + "</p>"
						+ "<p>stock change: " + change + "</p>"
						+ "<p>price this morning: " + open  + "</p>" 
						+ "<p>range high: " + rangeHigh + "</p>"
						+ "<p>Range low: " + rangeLow + "</p>" 
						+ "<p>Volume: " + volume + "</p>" 
						+ "<p>Chart: " + chart + "</p>";
			
			$("#display").html(allContent); 
			
			
		}
	});
});