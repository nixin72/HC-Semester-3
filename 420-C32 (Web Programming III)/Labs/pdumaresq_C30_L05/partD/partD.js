var ch = require("chalk");
var _ = require("underscore");

var anArray = [10, 5, 112, -34, -12, 45, 1, 51, -5, 234, 4, 556, -2];

console.log(_.max(anArray));

console.log(_.countBy(anArray, function(num) {
		if (num % 2 == 0) {
			return "even";
		}
		else {
			return "odd";
		}
}));

console.log(_.countBy(anArray, function(num) {
		if (num > 0) {
			return "greater than 0";
		}
		else {
			return "less than 0";
		}
}));
	
console.log(ch.red("Philip"));

console.log(ch.bgWhite(ch.black("modules are cool")));