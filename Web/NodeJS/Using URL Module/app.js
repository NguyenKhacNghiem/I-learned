let http = require('http');
let url = require('url');

http.createServer(function (req, res) {
	// Link: http://localhost:8080/default.html?year=2017&month=february
	res.writeHead(200, {'Content-Type': 'text/html'}); 

	res.write(`Url after domain (host) is ${req.url} </br>`); // /default.html?year=2017&month=february

	let queryString = url.parse(req.url, true);
	res.write(`Host: ${queryString.host} </br>`); // null vì đường dẫn hiện tại đang ở local thì không có hostname. Còn nếu gán trực tiếp vô thì sẽ là localhost:8080
	res.write(`Path: ${queryString.pathname} </br>`); // /default.html
	res.write(`Search: ${queryString.search} </br>`); // ?year=2017&month=february

	let args = queryString.query
	res.write(`Year is ${args.year} </br>`); // 2017
	res.write(`Month is ${args.month} </br>`); // february

	res.end(); 
}).listen(8080); 