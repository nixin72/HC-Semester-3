//utiltiies for HTTP
var http = require('http');
//file serving
var fs = require('fs');
//query strings
var querystring = require('querystring');
//utilities for file paths
var path = require('path');

//globals
global.PORT = '8080';
global.WEBROOT = './public';

http.createServer(function(request, response) {
	var data = "";
	
	// serve static form
	if (request.method == "GET") {
		getFile(path.join(__dirname, WEBROOT, "simpleform.html"), response);
	}
	
	//handle POST
	if (request.method == "POST") {
		request.on("data", function(chunk) {
			//append latest chunk to data already received
			data += chunk;
		});
		request.on("end", function() {
			var params = querystring.parse(data);
			var username = params.firstName + " " + params.lastName;
			console.log(username);
			console.log(params);
			response.end("<html><head><title></title></head><body><h2>" + username + "</h2></body></html>")
		});
	}
}).listen(PORT);

console.log("Server started on port %s", PORT);

function getFile(localPath, response) {
	//read the file and return it or send error 500
	fs.readFile(localPath, function(err, contents) {
		if (!err) {
			//use default header information
			response.end(contents);
		} else {
			console.log("ERROR ERROR ERROR");
			console.log(err.code + " " + err.message);
			response.writeHead(500);
			response.end();
		}
	});
}