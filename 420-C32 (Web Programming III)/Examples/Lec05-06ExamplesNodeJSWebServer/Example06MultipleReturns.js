var http = require('http');
var url = require('url');

const PORT = 1357;

http.createServer(function (req, res) {
	console.log(req.url);
  var pathname = url.parse(req.url).pathname;
  console.log(pathname);

  if (pathname === '/') {
      res.writeHead(200, {
      'Content-Type': 'text/html'
    });
	res.write("<html><head><title>Our Home Page</title></head><body>")
	res.write("<h1>Our Home Page</h1><p>This is it</p></body></html>")
    res.end()
  } else if (pathname === '/about') {
      res.writeHead(200, {
      'Content-Type': 'text/plain'
    });
    res.end('About Us\n')
  } else if (pathname === '/redirect') {
      res.writeHead(301, {
      'Location': '/'
    });
    res.end();
  } else if (pathname === '/error') {
      res.writeHead(200, {
      'Content-Type': 'text/html'
    });
	res.write("<html><head><title>Our Error Page</title></head><body>")
	res.write("<h1>Our Home Page</h1><p>This is it</p></body></html>")
    res.end();
  } else {
      res.writeHead(404, {
      'Content-Type': 'text/plain'
    });
    res.end('Page not found\n')
  }
}).listen(PORT);

console.log('Listening on port: ' + PORT);