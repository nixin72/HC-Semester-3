var express = require('express');
var app = express();
var fs = require('fs');
var dataLoc = __dirname + "/data/";

app.use('/message', function(req,res) {
    console.log('user requested endpoint');
    
    res.send('hello - end point reached');
});


app.use('/users', function(req,res) {
    fs.readFile(dataLoc + 'data1.json', 'utf-8', function(err, data) {
        res.send(data);
    });
	console.log('user information requested');
});

app.use('/books', function(req,res) {
    fs.readFile(dataLoc + 'books.json', 'utf-8', function(err, data) {
        res.send(data);
    });
	console.log('book list requested');
});

app.listen(9000);
console.log("Server started on port 9000");