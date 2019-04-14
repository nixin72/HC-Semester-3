var express = require('express');
var app = express();

fileLocation = __dirname + "/public";

app.use(express.static(fileLocation));

app.listen(9000);
console.log("Listening on port 9000");