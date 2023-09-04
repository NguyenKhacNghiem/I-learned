// Import module http và gán nó vào 1 đối tượng
let http = require('http');

// Tạo web server (giống Apache)
http.createServer(function (req, res) {
	res.writeHead(200, {'Content-Type': 'text/html'}); // trả về HTTP Header cho client. 200 là mã thành công
	res.write('Hello World!') // in ra web cho client (giống echo trong PHP).
	res.end(); // kết thúc response sau khi xử lý xong hết request -> bắt buộc phải có nếu không web sẽ đứng
}).listen(8080); // port để chạy server
