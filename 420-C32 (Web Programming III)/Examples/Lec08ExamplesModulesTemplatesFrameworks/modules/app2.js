var flight = require('./flight2');

var pdxlax = {
	number: 847,
	origin: 'PDX',
	destination: 'LAX'
};

var pl = flight(pdxlax);

pl.triggerDepart();

console.log(pl.getInformation());

var ausdca = {
	number: 382,
	origin: 'AUS',
	destination: 'DCA'
};
var ausdca2 = {
	departs: 12345678
};
var ad = flight(ausdca);
var ad = flight(ausdca2);

console.log(ad.getInformation());

console.log(pl.getInformation());