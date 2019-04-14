//utiltiies for HTTP
var http = require('http');
var url = require('url');
var querystring = require('querystring');

http.createServer(function(request, response) {
	if (request.url === '/favicon.ico') {
		response.end();
		console.log('favicon requested');
	}

	
	//parse eveything after the ? into key/value pairs
	// var qsObj = querystring.parse(request.url.split("?")[1]);
	
	var urlObj = url.parse(request.url);
	var qsObj = querystring.parse(urlObj.query);
	
	
	var username = qsObj.firstName + " " + qsObj.lastName;
	
	console.log(username);
	console.log(urlObj);
	console.log(qsObj);
	
	response.writeHead(200, {
      'Content-Type': 'text/html'
    });
	response.end("<html><head><title></title></head><body><h2>" + username + "</h2></body></html>");
}).listen(8080);

