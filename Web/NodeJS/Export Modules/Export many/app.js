let exampleModule = require('./module'); // không có đuôi .js. Lúc này, exampleModule sẽ là module.exports
let http = require('http');

http.createServer(function (request, response) {
	response.writeHead(200, {'Content-Type': 'text/html'});
	response.write('f1: ' + exampleModule.f1(5, 4) + '<br>');
	response.write('f2: ' + exampleModule.f2(5, 2) + '<br>');
	response.write('total: ' + exampleModule.total + '<br>');
	response.write('nhan: ' + exampleModule.nhan(3, 5) + '<br>');
	response.end()
}).listen(8080);
