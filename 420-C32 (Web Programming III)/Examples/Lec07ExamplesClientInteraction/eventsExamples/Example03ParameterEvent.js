var events = require('events');
var eventEmitter = new events.EventEmitter();

// var ringBell = (ring) =>  console.log(ring + " sent in");
var ringBell = (ring,ding) =>  console.log(ring + " sent in from " + ding);

eventEmitter.on('doorOpen', ringBell);

// eventEmitter.emit('doorOpen', 'ring-a-ling');
eventEmitter.emit('doorOpen', 'ring-a-ling', 'Allan', 'Doggie');