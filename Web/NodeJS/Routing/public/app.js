let http = require('http');
let fs = require('fs'); // fs is file system
let uc = require('upper-case'); // using the downloaded module via yarn

function routing(res, path, contentType, responseCode) {
    if(!responseCode) // if responseCode == null -> not send
        responseCode = 200;
    
    fs.readFile(path, function(err, data) {
        // File not found
        if(err) {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            return res.end("500 Internal Error");
        }

        res.writeHead(responseCode, { 'Content-Type': contentType });
        return res.end(data);
    });
}

http.createServer(function (req, res) {
    // normalize the url
    let path = req.url.replace(/\/?(?:\?.*)?$/, '').toLowerCase(); // regex

    // routing
    switch(path) {
        case '':
            routing(res, './public/html/index.html', 'text/html');
            break;
        case '/about':
            routing(res, './public/html/about.html', 'text/html');
            break;
        case '/contact':
            routing(res, './public/html/contact.html', 'text/html');
            break;
        case '/logo.jpg':
            routing(res, './public/img/logo.jpg', 'image/jpeg');
            break;
        default:
            routing(res, './public/html/error.html', 'text/html', 404);
            break;
    }
}).listen(8080, () => {
    // test the downloaded module via yarn
    let s = "hello";
    console.log(uc.upperCase(s))
});