var http = require('http');
const PORT = 8080;

http.createServer(function(request, response) {
	response.writeHead(301, {
		'Location': 'http://www.cegep-heritage.qc.ca'
	});
  response.end();
	}).listen(PORT);
	console.log('Listening on port: ' + PORT);