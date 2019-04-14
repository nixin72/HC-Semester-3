fs = require('fs');

data = fs.readdirSync('h:/');
console.log('data:', data);

console.error("this comes after");