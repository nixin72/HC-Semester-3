var http = require('http');

var testUrls = ['www.ctv.ca', 'www.cnn.com', 'www.tsn.ca', 'nodejs.org','www.cegep-heritage.qc.ca','www.uottawa.com'];

var fetchPage = function(url) {
  var start = new Date();
	http.get({ host: url }, function(res) {
		console.log("Got response from: " + url);
		console.log('Request took:', new Date() - start, 'ms');
	});
}

for(var i = 0; i < testUrls.length; i++) {
  fetchPage(testUrls[i]);
}