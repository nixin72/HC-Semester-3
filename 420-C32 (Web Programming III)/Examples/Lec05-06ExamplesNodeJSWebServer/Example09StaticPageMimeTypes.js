//utiltiies for HTTP
var http = require('http');
//utilities for file system
var fs = require('fs');
//utilities for file paths
var path = require('path');

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
	var filename = path.basename(request.url) || "index.html";
	var ext = path.extname(filename);
	var localPath = __dirname + "/public/";
	var pathname = path.dirname(request.url).substring(1);
	console.log(filename);
	console.log(ext);
	console.log(localPath);
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
}).listen(LISTEN_PORT);

function getFile(localPath, mimeType, response) {
	//read the file and return it or send error 500
	fs.readFile(localPath, function(err, contents) {
		if (!err) {
			response.setHeader("Warning", "99 Problems");
			response.setHeader("Allan", "McDonald");
			response.setHeader("Content-Type","text/plain");
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