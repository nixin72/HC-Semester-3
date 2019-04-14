/**
 * Created by 1523066 on 10/19/2016.
 */
var http = require("http");
var url = require("url");
var fs = require("fs");
var qs = require("querystring");
var path = require("path");

const PORT = 8000;
const WEBROOT = "./public";

var server = http.createServer(function (req, resp) {
    var queryString = path.basename(req.url);
    var urlObj = url.parse(req.url);

    fs.open(WEBROOT + "/bGetForm.html", "r", function (err, rd) {
        if (queryString == "") {
            fs.readFile(WEBROOT + "/bGetForm.html", function (err, data) {
                resp.writeHead(200, "Okay", {"content-type": "text/html"});
                resp.end(data);
            });
        }
        else {
            var qsObj = qs.parse(urlObj.query);

            console.log(qsObj);
            var username = qsObj.username;
            var phonenum = qsObj.phonenumber;
            var school = qsObj.school;
            
            fs.readFile("", function (err, data) {
                console.log(data);
                resp.writeHead(200, "Okay", {"content-type": "text/html"});
                resp.end("<html><body><h2>" + username + "</h2><h3>"
                                            + phonenum + "<br />"
                                            + school + "</h3></body></html>");
            });
        }
    });
});
server.listen(PORT);