//utiltiies for HTTP
var http = require('http');
//utilities for file system
var fs = require('fs');
//utilities for file paths
var path = require('path');

const DEFAULT_EXT = ".html";
const PORT = 8080

http.createServer(function(request, response) {
	//look for a file name in the url or default to index.html
	//var filename = path.basename(request.url) || "index.html";
	var filename = path.basename(request.url);
	var ext = path.extname(request.url);
	var localPath = __dirname + "/public";
	var pathname = path.dirname(request.url);
	console.log(filename);
	console.log(ext);
	console.log(localPath);
	//get around the root folder ending in / and no other does issue
	pathname += (pathname !== "/") ? "/" : ""
	
	if (ext == DEFAULT_EXT) {
		localPath = localPath + pathname + filename;

		console.log("Getting this file: " + localPath);
		//verify that the file exists or return 404
		// fs.exists(localPath, function(exists) {
			// if (exists) {
				// getFile(localPath, response);
			// } else {
				// response.writeHead(404);
				// response.end('File not found');
			// }
		// });
		fs.open(localPath, 'r', (err, fd) => {
			if (err) {
				if (err.code === "ENOENT") {
					console.error('File does not exist');
					response.writeHead(404);
					response.end('File Not Found');
				} else {
					console.log("Unhandled exception: " + err.code);
					response.writeHead(500);
					response.end("Unknown server error");
				}
			} else {
				fs.close(fd);
				getFile(localPath, response);
			}
		});
		// fs.open(localPath, 'r', (err, fd) => {
			// if (err) {
				// if (err.code === "ENOENT") {
					// console.error('File does not exist');
					// response.writeHead(404);
					// response.end('File Not Found');
				// } else {
					// console.log("Unhandled exception: " + err.code);
				// }
			// } else {
				// console.log('About to read');
				// var buffer = new Buffer(2000);
				// fs.read(fd, buffer,0,2000,null, function (err, bytesRead, fileData) {
					// if (err) {
						// console.log(err);
					// }
					// response.writeHead(200, {
						// 'Content-Length': fileData.length
					// });
					// response.end();
				// });
			// }
		// });
	} else {
		response.writeHead(415);
		response.end("Invalid file type");
		console.log("Non-HTML file");
	}
}).listen(PORT);

function getFile(localPath, response) {
	//read the file and return it or send error 500
	fs.readFile(localPath, function(err, contents) {
		if (!err) {
			//use default header information
			response.end(contents);
		} else {
			console.log("Server error");
			response.writeHead(500);
			response.end("cannot read file");
		}
	});
}