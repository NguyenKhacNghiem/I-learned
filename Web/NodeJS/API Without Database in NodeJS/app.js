const http = require('http');
const url = require('url');

// Danh sách sinh viên mẫu
const students = [
    {id: 1, name: 'Student A', email: 'a@gmail.com'},
    {id: 2, name: 'Student B', email: 'b@gmail.com'},
    {id: 3, name: 'Student C', email: 'c@gmail.com'},
    {id: 4, name: 'Student D', email: 'd@gmail.com'},
    {id: 5, name: 'Student E', email: 'e@gmail.com'}
];

http.createServer((req, res) => {
    let pathname = url.parse(req.url, true).pathname;

    // GET all
    if (req.method === 'GET' && pathname === '/students') {
        res.writeHead(200, {'Content-Type': 'application/json'});
        res.end(JSON.stringify(students));
    } 

    // POST
    else if (req.method === 'POST' && pathname === '/students') {
        let body = '';

        req.on('data', chunk => {
            body += chunk.toString();
        });

        req.on('end', () => {
            let json = JSON.parse(body);
            
            if(!json.name || !json.email) {
                res.writeHead(404, {'Content-Type': 'application/json'});
                res.end(JSON.stringify({error: "Name và email chưa được gửi"}));
            }
            else {
                let newStudent = {
                    id: students[students.length - 1].id + 1, // id tự tăng
                    name: json.name,
                    email: json.email
                }

                students.push(newStudent);

                res.writeHead(201, {'Content-Type': 'application/json'});
                res.end(JSON.stringify(newStudent));
            }
        });
    } 

    // GET one
    else if (req.method === 'GET' && pathname.startsWith('/students/')) {
        let studentId = parseInt(pathname.slice(10)); 
        let student = students.find(s => s.id === studentId);

        if (!student) {
            res.writeHead(404, {'Content-Type': 'application/json'});
            res.end(JSON.stringify({error: 'Sinh viên không tồn tại'}));
        } 
        else {
            res.writeHead(200, {'Content-Type': 'application/json'});
            res.end(JSON.stringify(student));
        }
    } 

    // PUT
    else if (req.method === 'PUT' && pathname.startsWith('/students/')) {
        let studentId = parseInt(pathname.slice(10));
        let body = '';

        req.on('data', chunk => {
            body += chunk.toString();
        });

        req.on('end', () => {
            let json = JSON.parse(body);
            let index = students.findIndex(s => s.id === studentId);

            if (index === -1) {
                res.writeHead(404, {'Content-Type': 'application/json'});
                res.end(JSON.stringify({error: 'Sinh viên không tồn tại'}));
            } 
            else {
                students[index].name = json.name;
                students[index].email = json.email;

                res.writeHead(200, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify(students[index]));
            }
        });
    } 

    // DELETE
    else if (req.method === 'DELETE' && pathname.startsWith('/students/')) {
        let studentId = parseInt(pathname.slice(10));
        let index = students.findIndex(s => s.id === studentId);

        if (index === -1) {
            res.writeHead(404, {'Content-Type': 'application/json'});
            res.end(JSON.stringify({error: 'Sinh viên không tồn tại'}));
        } 
        else {
            let deletedStudent = students[index]; // hold the student before deleting in order to res.end() below
            students.splice(index, 1); // delete

            res.writeHead(200, {'Content-Type': 'application/json'});
            res.end(JSON.stringify(deletedStudent));
        }
    } 

    // Invalid endpoints
    else {
        res.writeHead(404, {'Content-Type': 'application/json'});
        res.end(JSON.stringify({error: 'Endpoint không tồn tại'}));
    }
}).listen(8080);
