var flight = require('./flight4');

var yowysj = {
	number: 847,
	origin: 'YOW',
	destination: 'YSJ'
};

var f1 = flight.create(yowysj);

f1.triggerDepart();

console.log(f1.getInformation());

var yowyqm = {
	number: 382,
	origin: 'YOW',
	destination: 'YQM'
};

var f2 = flight.create(yowyqm);

var yyzyqm = {
	number: 382,
	origin: 'YYZ',
	destination: 'YQM'
};

var f3 = flight.create(yyzyqm);

console.log(f2.getInformation());

console.log(f3.getInformation());

console.log(f1.getInformation());

f1.setNumber(99999);
f2.setOrigin("XYZ")

console.log(f1.getInformation());
console.log(f2.getInformation());

console.log(flight.getCount());
console.log(flight.getDestinations());

console.log(f3.getOrigin());