var flight = require('./flight');

flight.setOrigin('YOW');
flight.setDestination('YSJ');
flight.setNumber(432);

console.log(flight.getInfo());

var newFlight = require('./flight');

console.log(newFlight.getInfo());