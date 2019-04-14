var newmath = require('./modules/math.js');

var result = newmath.sum(5,2)
	
console.log('The result is:', result);

var secondresult = newmath.sum(6,result); 
console.log('The second result is:', secondresult);
