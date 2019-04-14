var util = require("util");
var http = require("http");
var fs = require("fs");
var url = require("url");
var path = require("path");
var qs = require("querystring");

const PORT = 9000;
const FILES = __dirname + "/public/";

http.createServer(function(req, resp) {
    var query = qs.parse((url.parse(req.url)).query);
    var pathname = path.dirname(req.url).substring(1);
    var file = path.basename(req.url);
    var ext = path.extname(file);

    console.log(query);
    console.log(pathname);
    console.log(file);
    console.log(ext);

    resp.end("hi");
}).listen(PORT);

