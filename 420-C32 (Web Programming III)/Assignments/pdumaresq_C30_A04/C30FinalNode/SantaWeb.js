var util = require("util");
var http = require("http");
var fs = require("fs");
var url = require("url");
var path = require("path");
var qs = require("querystring");
var request = require("./node_modules/request");

var fileType = {
    ".html": "text/html",
    ".htm": "text/html",
    ".css": "text/css",
    ".xml": "text/xml",
    ".txt": "text/plain",
    ".gif": "image/gif",
    ".png": "image/png",
    ".svg": "image/svg+xml",
    ".jpg": "image/jpeg",
    ".jpeg": "image/jpeg",
    ".ico": "image/x-icon",
    ".pdf": "application/pdf",
    ".js": "application/javascript"
};

const PORT = 7546;
const FILES = path.join(__dirname, "/public/");
const ERROR = path.join(__dirname, "/errorPages/");

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
    var requestedPage = FILES + pathName + "\\" + fileName;
    if (req.url === '/favicon.ico') {
        loadPage(requestedPage, fileName[ext], resp, 200, "okay");
    }
    else if (fileName.match(/\?/)) {
        requestChildren(querystring, resp);
        ext = ext.substring(0, ext.indexOf("?"));
        fileName = fileName.substring(0, fileName.indexOf("?"));
    }
    else {
        if (fileType[ext]) {
            fs.open(requestedPage, "r", function (err, fd) {
                if (err) {
                    getErrorType(err, resp);
                }
                else {
                    process.nextTick(function () {
                        fs.close(fd);
                        loadPage(requestedPage, fileType[ext], resp, 200, "Okay");
                    });
                }
            });
        }
        else {
            process.nextTick(function () {
                if (fileName == "")
                    loadPage(ERROR + "404.html", fileType[".html"], resp, 404, "Not Found");
                else
                    loadPage(ERROR + "415.html", fileType[".html"], resp, 415, "Invalid file extension");
            });
        }
    }
});
server.listen(PORT);

function getErrorType(err, resp) {
    console.log("ERROR");
    console.log(err.code);
    if (err.code == "ENOENT") {
        loadPage(ERROR + "404.html", fileType[".html"], resp, 404, "Not Found");
    }
    else {
        loadPage(ERROR + "500.html", fileType[".html"], resp, 500, "Internal Server error");
    }
}

function loadPage(fileName, mimeType, resp, returnStatus, returnMessage) {
    fs.readFile(fileName, function (err, data) {
        if (err) {
            getErrorType(err, resp);
        }
        else {
            resp.writeHead(returnStatus, returnMessage, {"Content-Type": mimeType});
            resp.end(data);
        }
    });
}

function requestChildren(name, resp) {
    var page = "";
    if (name['file'] == "getListInfo.php") {
        page = name['file'] + "?which=" + name['which'];
    }
    else {
        page = name['file'] + "?id=" + name['id'];
    }
    var csdev = 'http://csdev.cegep-heritage.qc.ca/students/1523066/assignments/pdumaresq_C30_A04v2.2/c30finalphp/';
    var home = "http://127.0.0.1:9000/";
    console.log(home + page);
    request(home + page, function (error, response, body) {
        console.log(error);
        if (!error && response.statusCode == 200) {
            resp.end(body);
        }
    });
}