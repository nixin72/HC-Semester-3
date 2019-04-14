var http = require('http');
var fs = require("fs");
var path = require('path');
var url = require('url');
const PORT= 3456;
const HTML_FOLDER = __dirname + "\\webbase";
const ERROR_FOLDER = __dirname + "\\errorpages";

var server = http.createServer(function (req, resp) {
    var INDEX = HTML_FOLDER + "\\" + path.basename(req.url);
    console.log(url.parse(req.url));

    resp.setHeader("Cache-Control","no-cache");
    resp.setHeader("Date",Date());
    resp.setHeader("warning","99 problems");

    fs.open(INDEX, "r", function(err, fd) {
        var fileType = "text/html";
        if (path.extname(req.url) == ".txt") {
            console.log("text file");
            fileType = "text/plain";
        }
        if (err) {
            if (err.code == "ENOENT") {
                fs.readFile(ERROR_FOLDER + "\\404.html", function(err, data) {
                    resp.writeHead(404, "not found", {"content-type": "text/html"});
                    resp.end(data);
                });
            }
            else {
                fs.readFile(ERROR_FOLDER + "\\500.html", function(err, data) {
                    resp.writeHead(500, "internal server error", {"content-type": "text/html"});
                    resp.end(data);
                });
            }
        }
        else if (path.basename(req.url) == "") {
            fs.readFile(HTML_FOLDER + "\\index.html", function(err, data) {
                resp.end(data);
            });
        }
        else {
            fs.readFile(INDEX, function(err, data) {
                resp.writeHead(200, "ok", {"content-type": fileType, "Philip": "Dumaresq"});
                resp.write(data);
            });
        }
    });
}).listen(PORT);
