var geometry = require('./bModules.js');

console.log(geometry.areaCircle(3));
console.log(geometry.areaRect(4,6));
console.log(geometry.perimRect(4,6));
console.log(geometry.isTriangle(3,4,5));
console.log(geometry.isTriangle(3,4,8));
console.log(geometry.areaCircle(geometry.areaRect(2,3)));
