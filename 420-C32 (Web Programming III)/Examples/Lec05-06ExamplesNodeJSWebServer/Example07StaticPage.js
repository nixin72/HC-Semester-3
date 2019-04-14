var http = require('http');
var fs = require('fs');

http.createServer(function(request, response) {
	getFile(response);
}).listen(8080);

function getFile(response) {
	console.log(__dirname);
	var fileName = __dirname + "/public/index.html";
	console.log(fileName);
	fs.readFile(fileName, function(err, contents) {
		if (!err) {
			response.end(contents);
		} else {
			response.end();
			console.log("ERROR ERROR ERROR");
		}
	});
}