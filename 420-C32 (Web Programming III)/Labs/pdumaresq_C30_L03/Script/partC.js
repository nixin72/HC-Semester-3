var httpRequest = false;
function getRequestObject() {
	try {
		httpRequest = new XMLHttpRequest();
	} catch (requestError) {
		window.alert("Your browser doesn't support AJAX!");
		return false;
	}
	return httpRequest;
}

function sportsUpdate() {
	getRequestObject();
	sport = document.getElementById("theSport").options[document.getElementById("theSport").selectedIndex].value;
	httpRequest.onreadystatechange = getSportsNews;
	httpRequest.open("GET", "php/SportingNews.php?sport=" + sport, true);
	httpRequest.send();

	setTimeout(sportsUpdate, 5000);
}

function getSportsNews() {
	document.getElementById("newsCell").innerhtml = "";
	if (this.readyState == 4 && this.status == 200) {
		var news = httpRequest.responseXML;
		var newsItems = news.getElementsByTagName("item");

		if (newsItems.length > 0) {
			for (var i = 0 ; i < newsItems.length ; i++ ) {
				var curHeadline = newsItems[i].getElementsByTagName("title")[0].childNodes[0].nodeValue;
				var curLink = newsItems[i].getElementsByTagName("link")[0].childNodes[0].nodeValue;
				var curPubDate = newsItems[i].getElementsByTagName("pubDate")[0].childNodes[0].nodeValue;
				var curDesc = newsItems[i].getElementsByTagName("description")[0].childNodes[0].nodeValue;
				var curStory = "<a href='" + curLink + "'>" + curHeadline + "</a><br />";
				curStory += "<span style='color: grey'>" + curPubDate + "</span><br />";
				curStory += curDesc + "<br />";
				document.getElementById("newsCell").innerHTML += curStory;
			}				
		} else {
			document.getElementById("newsCell").innerHTML = "RSS feed doesn't contain any items";
		}
	}
}

document.getElementById("theSport").addEventListener("change", sportsUpdate);