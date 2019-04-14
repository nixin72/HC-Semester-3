var events = require('events');
var pingPong = new events.EventEmitter();

pingPong.on('ping', () => {
	console.log('Got ping');
	setTimeout(()=>{
		pingPong.emit('pong');
	}, 2000);
});

pingPong.on('pong', () => {
	console.log('Got pong');
	setTimeout(()=>{
		pingPong.emit('ping');
	}, 2000);
});

setTimeout(()=>{
	console.log('Adding second ping event listener');
	pingPong.on('ping', () => {
		console.log('Second ping listener now');
	});
}, 6000);

console.log('Sending first ping');
pingPong.emit('ping');



