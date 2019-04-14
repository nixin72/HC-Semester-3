//utiltiies for HTTP
var http = require('http');
//utilities for file system
var fs = require('fs');
//utilities for file paths
var path = require('path');
var mustache = require('mustache');

const LISTEN_PORT = 8999;

http.createServer(function(request, response) {
	var readableStream = fs.createReadStream('./templates/template1.mst');

	var template = '';
	var data = { name: 'Allan',  ease: 'Simple' }
	
	readableStream.setEncoding('utf8');

	readableStream.on('data', (chunk) => {
		template+=chunk;
	});

	readableStream.on('end', () => {
		html = mustache.to_html(template, data)
		console.log(html);
		response.end(html);
	});
	
}).listen(LISTEN_PORT);

