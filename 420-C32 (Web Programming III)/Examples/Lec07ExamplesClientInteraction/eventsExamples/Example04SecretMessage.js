var events = require('events');
var secretMessage = new events.EventEmitter();

secretMessage.on('message', (data) => {
	console.log(data)
});

secretMessage.on('self destruct', () => {
	console.log('BANG!! The message is destroyed');
});

secretMessage.emit('message', "This message will self destruct in 5 seconds...");

setTimeout(()=>{secretMessage.emit('self destruct');}, 5000);

secretMessage.emit('message', 'Do you accept your mission?');