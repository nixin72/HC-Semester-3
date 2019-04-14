//utiltiies for HTTP
var http = require('http');
//utilities for file system
var fs = require('fs');
//utilities for file paths
var path = require('path');
var pug = require('pug');

const LISTEN_PORT = 8999;

http.createServer(function(request, response) {
	var compiledTemplate = pug.compileFile('./templates/template1.pug');
		
	var resultFile = compiledTemplate( 
		{ name: 'Allan',
	       ease: 'Simple'
		}
	);
	console.log(resultFile);
	response.end(resultFile);
}).listen(LISTEN_PORT);

