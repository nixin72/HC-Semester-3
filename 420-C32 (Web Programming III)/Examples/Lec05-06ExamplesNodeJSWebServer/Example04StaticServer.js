var http = require('http');
const PORT = 8081;

http.createServer(function(request, response) {
	var html = "<!doctype html>" +
		"<html><head><title>Static page from Node</title></head>" + 
		"<body><h1>First Node page</h1><p>Node created and sent this response</p></body></html>";
		
	response.writeHead(200, {
		//set the content type
		"Content-Type": "text/html",
		//set the length returned
		"Content-Length": html.length
		// ,"My-Header": "This is from the server"
		});
		//end the response and send the html page created
		response.end(html);
		// console.log(request.url);
		// console.log(__dirname);
	}).listen(PORT);
	console.log('Listening on port: ' + PORT);