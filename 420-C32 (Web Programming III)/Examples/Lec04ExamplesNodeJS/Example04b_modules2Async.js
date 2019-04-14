var newmath = require('./modules/mathAsync.js');

newmath.sum(1, 2, function(err, result){
    if(err){
        throw err;
    }
	
    console.log('The result is:', result);
	newmath.sum(6,result, function(err, secondresult) {
		console.log('The second result is:', secondresult);
	});	
});
console.log("Hello everybodeeeee");

