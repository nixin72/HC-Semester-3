var util = require("util");
var http = require("http");
var fs = require("fs");
var url = require("url");
var path = require("path");
var qs = require("querystring");
var User = require("./User");
var xml2js = require("./node_modules/xml2js");

var fileType = {
    ".html": "text/html",
    ".css" : "text/css",
    ".xml" : "text/xml",
    ".txt" : "text/plain",
    ".gif" : "image/gif",
    ".png" : "image/png",
    ".svg" : "image/svg+xml",
    ".jpg" : "image/jpeg",
    ".jpeg": "image/jpeg",
    ".ico" : "image/x-icon",
    ".pdf" : "application/pdf",
    ".js"  : "application/javascript",
};

const PORT   = 9000;
const FILES  = path.join(__dirname, "..", "pdumaresqC30A02root/public/");
const ERROR  = path.join(__dirname, "..", "pdumaresqC30A02root/errorPages/");
const DATA   = path.join(__dirname, "..", "pdumaresqC30A02data/");

var server = http.createServer(function (req, resp) {
    var querystring = qs.parse((url.parse(req.url)).query);
    var pathName = path.dirname(req.url).substring(1);
    var fileName = path.basename(req.url);
    var ext = path.extname(fileName);
    if (ext == "") {
        pathName = "";
        fileName = "index.html";
        ext = ".html";
    }
    if (ext.includes("?")) {
        ext = ext.substring(0, ext.indexOf("?"));
        fileName = fileName.substring(0, fileName.indexOf("?"));
    }
    var requestedPage = FILES + pathName + "\\" + fileName;

    fs.appendFile(DATA + "logs/web.log", "\r\nRequest: " + requestedPage + "\r\n");
    if (req.url === '/favicon.ico') {
        loadPage(requestedPage, fileName[ext], resp, 200, "okay");
    }
    else {
        if (pathName == "bin") {
            process.nextTick(function() {
                requestXML(ext, querystring, resp, fileName);
            });
        }
        else {
            if (fileType[ext]) {
                fs.open(requestedPage, "r", function (err, fd) {
                    if (err) {
                        getErrorType(err, resp);
                    }
                    else {
                        process.nextTick(function() {
                            if (req.method == "POST") {
                                handlePOSTRequest(req, resp);
                            }
                            else {
                                fs.close(fd);
                                loadPage(requestedPage, fileType[ext], resp, 200, "Okay");
                            }
                        });
                    }
                });
            }
            else {
                process.nextTick(function() {
                    if (fileName == "")
                        loadPage(ERROR + "404.html", fileType[".html"], resp, 404, "Not Found");
                    else
                        loadPage(ERROR + "415.html", fileType[".html"], resp, 415, "Invalid file extension");
                });
            }
        }
    }
});
server.listen(PORT);

function getErrorType(err, resp) {
    if (err.code == "ENOENT") {
        loadPage(ERROR + "404.html", fileType[".html"], resp, 404, "Not Found");
    }
}

function loadPage(fileName, mimeType, resp, returnStatus, returnMessage) {
    fs.readFile(fileName, function (err, data) {
        if (err) {
            getErrorType(err, resp);
        }
        else {
            fs.appendFile(DATA + "logs/web.log", "Response: " + fileName + "--> " + returnStatus + ": " + returnMessage + "\r\n");
            resp.writeHead(returnStatus, returnMessage, {"Content-Type": mimeType});
            resp.end(data);
        }
    });
}

function handlePOSTRequest(req, resp) {
    var data = "";
    req.on("data", function (chunk) {
        data += chunk;
    });

    req.on("end", function () {
        var params = qs.parse(data);
        var userObj = { firstName: null, lastName: null, username: null, emailAddress: null, phoneNum: null };

        for (var par in params)
            userObj[par] = params[par];
        var user = User.create(userObj);

        var uInfo = "";
            uInfo += user.getFirstName() + ", ";
            uInfo += user.getLastName() + ", ";
            uInfo += user.getUsername() + ", ";
            uInfo += user.getEmailAddress() + ", ";
            uInfo += user.getPhoneNumber();

        fs.appendFile(DATA + "logs/web.log", "Response: " + uInfo + " --> 200: Okay");
        fs.appendFile(DATA + "users.txt", uInfo + "\n", function (err) {
            if (err) {
                loadPage(ERROR + "520.html", fileType[".html"], resp, 520, "Not Found");
            }
            else {
                var html = "<html><head><title>Form return</title><style>" +
                    "body{width:70%;margin:auto;background-color:#828282}" +
                    "div{background-color:#cccccc;padding:15%5%}" +
                    "</style></head><body><div><h1>Information entered: <br /><br />" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;First name: " + user.getFirstName() + "<br />" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;Last name: " + user.getLastName() + "<br />" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;Username: " + user.getUsername() + "<br />" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;Email Address: " + user.getEmailAddress() + "<br />" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;Phone number: " + user.getPhoneNumber() + "<br />" +
                    "</h1></div></body></html>";
                resp.writeHead(200, "Okay", {"Content-Type": fileType[".html"]});
                resp.end(html);
            }
        });
    });
}

function requestXML(ext, querystring, resp, fileName) {
    var requestedPage = DATA + "\\xml\\" + fileName;

    fs.open(requestedPage, "r", function (err) {
        if (ext != ".xml") {
            loadPage(ERROR + "400.html", fileType[".html"], resp, 400, "Invalid request");
        }
        else {
            if (err) {
                console.log(requestedPage);
                getErrorType(err, resp);
            }
            else {
                if (Object.keys(querystring).length == 0) {
                    loadPage(ERROR + "406.html", fileType[".html"], resp, 406, "Invalid parameters");
                }
                else {
                    fs.readFile(requestedPage, function (err, data) {
                        var parseString = xml2js.parseString;

                        parseString(data, function (err, result) {
                            var display = [];
                            var numFound = 0;

                            var data;
                            for (var upper in result)
                                for (var i in result[upper])
                                    data = result[upper][i];

                            for (var key in data) {
                                var match = true;
                                    for (var q in querystring) {
                                            if (data[key][q] == querystring[q]) {
                                                match = match && true;
                                                numFound++;
                                            }
                                            else
                                                match = false;
                                     }
                                    if (match)
                                            display.push(data[key]);
                            }

                            process.nextTick(function() {
                                if (display.length == 0) {
                                    loadPage(ERROR + "416.html", fileType[".html"], resp, 416, "Range not satisfiable");
                                }
                                else {
                                    displayAsHTML(display, resp);
                                }
                            });
                        });//parseString
                    });//fs.readFile
                }//else (querystring exists)
            }//else (no error)
        }//else (ext == .xml)
    });//fs.open
}//requestXML

function displayAsHTML(xml, resp) {
    for (var k = 0; k < xml.length; k++)
        for (var i = 1; i < xml.length; i++)
            if (equals(xml[k], xml[i]) && (i != k))
                xml.splice(i, 1);

    var html = "<html><head><title>data received</title></head><body>";
    for (var q = 0; q < xml.length; q++) {
        for (var key in xml[q])
            if (key == "$")
                    for (var at in xml[q][key])
                            html += "<h3>" + at + ": " + xml[q][key][at];
            else
                html += "<h3>" + key + ": " + xml[q][key] + "</h3>";

        html += "<br />";
    }
    html += "</body></html>";

    fs.appendFile(DATA + "logs/web.log", "Response: " + xml + "--> " + 200 + ": Okay");
    resp.writeHead(200, "Okay", {"Content-type": fileType[".html"]});
    resp.end(html);
}

function equals(obj1, obj2) {
    var equal = true;
    for (var key in obj1) {
        (key in obj2) ?
            ((obj1[key] == obj2[key]) ?
                equal = equal && true
                : equal = false)
            : equal = false;
    }
    return equal;
}