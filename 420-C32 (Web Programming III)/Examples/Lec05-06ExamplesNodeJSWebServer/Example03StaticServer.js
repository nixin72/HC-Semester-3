var http = require('http');
const PORT = 8080;

http.createServer(function(request, response) {
		response.end('Hello from nodejs');
		console.log('Request received');

		console.log("URL is: " + request.url);
		console.log("Directory is: " + __dirname);
	}).listen(PORT);
	console.log('Listening on port ' + PORT);
	
// http.createServer(function(request, response) {
		// doServer(request, response);
	// }).listen(PORT);
// console.log('Listening on port ' + PORT);

	
// var doServer = function(req, res) {
	// console.log('Request received');
	// res.end("Hello there");
	// console.log("Response sent");
	// console.log("URL is: " + req.url);
	// console.log("Directory is: " + __dirname);
// }