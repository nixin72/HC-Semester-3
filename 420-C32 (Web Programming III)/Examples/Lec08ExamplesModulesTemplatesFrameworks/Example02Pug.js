var http = require('http');
var fs = require('fs');
var path = require('path');
var querystring = require('querystring');

var pug = require('pug');

const DEFAULT_EXT = ".html";
const LISTEN_PORT = 8080;
var extensions = {
	".html": "text/html",
	".css": "text/css",
	".js": "application/javascript",
	".png": "image/png",
	".gif": "image/gif",
	".jpg": "image/jpeg"
};

http.createServer(function(request, response) {
	//look for a file name in the url or default to index.html
	if (request.method == "GET") {
		var filename = path.basename(request.url) || "index.html";
		var ext = path.extname(filename);
		var localPath = __dirname + "/public/";
		var pathname = path.dirname(request.url).substring(1);
		//get around the root folder ending in / and no other does issue
		pathname += (pathname !== "/") ? "/" : ""
		
		if (request.url === '/favicon.ico') {
			response.end();
			console.log('favicon requested');
		}
		
		if (extensions[ext]) {
			localPath = localPath + pathname + filename;
	
			console.log("Getting this file: " + localPath);
			//verify that the file exists or return 404
			fs.open(localPath, 'r', (err, fd) => {
				if (err) {
					if (err.code === "ENOENT") {
						console.error('File does not exist');
						response.writeHead(404);
						response.end('File Not Found');
					} else {
						console.log("Unhandled exception: " + err.code);
					}
				} else {
					fs.close(fd);
					getFile(localPath, extensions[ext], response);
				}
			});
			
		} else {
			response.writeHead(415);
			response.end("Invalid file type");
			console.log("Non-HTML file");
		}
	} else {
	//handle POST
		var data = "";
		if (request.method == "POST") {
			request.on("data", function(chunk) {
				//append latest chunk to data already received
				data += chunk;
			});
			request.on("end", function() {
				var params = querystring.parse(data);
				console.log('Parameter object: ');
				console.log(params);
				var compiledTemplate = pug.compileFile('./templates/template2.pug');
			
				var resultFile = compiledTemplate( params );
				console.log(resultFile);
				response.end(resultFile);
			});
		}
	}
}).listen(LISTEN_PORT);

function getFile(localPath, mimeType, response) {
	//read the file and return it or send error 500
	fs.readFile(localPath, function(err, contents) {
		if (!err) {
			response.writeHead(200, {
				"Content-Type": mimeType,
				"Content-Length": contents.length
			});
			//use default header information
			response.end(contents);
		} else {
			console.log("ERROR ERROR ERROR");
			response.writeHead(500);
			response.end();
		}
	});
}