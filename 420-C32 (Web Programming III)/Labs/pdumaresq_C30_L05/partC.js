var geometry = require('./cModules.js');

geometry.areaCircle(3, function(err, result) {
	if(err)
		throw err;
	
	console.log(result);
});

geometry.areaRect(4,6, function(err, result) {
	if(err)
		throw err;
	
	console.log(result);
});

geometry.perimRect(4,6, function(err, result) {
	if(err)
		throw err;
	
	console.log(result);
});

geometry.isTriangle(3,4,5, function(err, result) {
	if(err)
		throw err;
	
	console.log(result);
});

geometry.isTriangle(3,4,8, function(err, result) {
	if(err)
		throw err;
	
	console.log(result);
});

geometry.areaRect(2,3, function(err,result){
	if(err)
		{throw err;}
	geometry.areaCircle(result, function(err, answer) {
		if(err) 
		{throw err;}
		console.log(answer);
	});
});

//console.log(geometry.areaCircle(geometry.areaRect(2,3)));



