fs = require('fs');

fs.readdir('h:/', function (err, data) {
	console.log('data:', data);
});

console.log("this comes after");