var fs = require('fs');

var readableStream = fs.createReadStream('./files/lorem.txt');
var writeableStream = fs.createWriteStream('./files/new.txt');

readableStream.pipe(writeableStream);