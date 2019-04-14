var fs = require('fs');

console.log("first Node.js");

fs.readdir('h:/', function (err, data) {
	console.log('data:', data);
});

console.log("this comes after");