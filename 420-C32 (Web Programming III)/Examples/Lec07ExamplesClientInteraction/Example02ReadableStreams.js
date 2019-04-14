//utiltiies for HTTP
var fs = require('fs');

var readableStream = fs.createReadStream('./files/lorem.txt');

var data = '';
var i = 1;

readableStream.setEncoding('utf8');

readableStream.on('data', (chunk) => {
	data+=chunk;
	console.log('Buffer: ' + i++);
});

readableStream.on('end', () => {
	console.log(data);
});
