var _ = require('underscore');
var chalk = require('chalk');

var numbers = [10, 5, 12, 34, 12, 45, 1, 5, -5, 234, 4, 556, 2];

_.each([1,2,3,6], function(num) {
		console.log('underscore says: ' + num);
	});
	
// _.each(numbers, function(num) {
		// console.log('underscore says: ' + num);
	// });
	
console.log(_.min(numbers));
console.log(chalk.blue.bgYellow.bold("Hello world", "Allan", "is", "great"));
console.log(chalk.green(
    'I am a green line ' +
    chalk.blue.underline.bold('with a blue substring') +
    ' that becomes green again!'
));
