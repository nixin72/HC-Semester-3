var https = require('https');
const USER = 'armcdon';
const PSWD = 'showClass';

var options = {
	host: 'stream.twitter.com',
	auth: USER + ":" + PSWD,
	path: '/l/statuses/filter.json?track=hockey',
	method: 'POST'
};

var req = https.request(options, (res) => {
	res.setEncoding('utf8');
	res.on('data', (tweets) => {
		var json = JSON.parse(tweets);
		console.log('New data');
		console.log(json.text);
	});
});