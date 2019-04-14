var http = require("http");
var url = require("url");
var fs = require("fs");
var qs = require("querystring");
var path = require("path");
const PORT = 1234;
const WEBROOT = "./public";

var server = http.createServer(function (req, resp) {
    if (req.method == "GET") {
        console.log("method = GET");
        fs.open(WEBROOT + "/cGetForm.html", "r", function (err, rd) {
           fs.readFile(WEBROOT + "/cGetForm.html", function (err, data) {
               resp.writeHead(200, "Okay", {"content-type": "text/html"});
               resp.end(data);
           });
        });
    }
    if (req.method == "POST") {
        var data = "";
        req.on("data", function(chunk) {
            data += chunk;
        });
        
        req.on("end", function() {
            var params = qs.parse(data);
            var fName = params.fName;
            var lName = params.lName;
            var email = params.email;
            fs.appendFile("data/cData.txt", fName + ", " + lName + ", " + email + "\n", function(err) {
                if (err) {
                    resp.end("Error, file wasn't written to");
                }
                else {
                    resp.end("<html><head><title></title></head><body>Success!!! :D <br /><h2>Data: "
                        + "<br />First name: " + fName
                        + "<br />Last name: " + lName
                        + "<br />Email: " + email
                        + "</h2></body></html>");
                }
            });
        });
    }
}).listen(PORT);
