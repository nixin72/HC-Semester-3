var events = require('events');
var eventEmitter = new events.EventEmitter();

var ringBell = () => console.log('jingle jingle jingle');

var santaHere = () => console.log('Ho! Ho! Ho!');

var wishWell = () => console.log('Have a Merry Christmas');

eventEmitter.on('merryChristmas', ringBell);
eventEmitter.on('merryChristmas', santaHere);
eventEmitter.on('merryChristmas', wishWell);
eventEmitter.on('merryChristmas', () => console.log("Bah! Humbug."));

eventEmitter.emit('merryChristmas');