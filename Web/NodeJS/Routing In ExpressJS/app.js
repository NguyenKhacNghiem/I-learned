// Import module ExpressJS và tạo đối tượng sử dụng
let express = require('express')
let app = express()

// Import module Handlebars và cấu hình cho project sử dụng view engine này
let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', // mặc định sử dụng layout main (file main.handlebars)
                           // ... nếu có các layout khác thì ghi vô
}))
app.set('view engine', 'handlebars')

// Static Middleware: xử lý hiển thị các file đa phương tiện (img, css,...)
app.use(express.static(__dirname + '/public'))

// GET Middleware: khi người dùng truy cập đường dẫn "/" với method GET
app.get('/', (req, res) => {
    let table = "";
    let rows = columns = 3;

    for(let i=1;i<=rows;i++) {
        table += "<tr>";

        for(let j=1;j<=columns;j++)
            table += `<td>${i+j}</td>`;
        
        table += "</tr>";
    }

    // Truyền dữ liệu từ biến table qua. Hay nói cách khác là gửi dữ liệu từ BE qua FE
    res.render('home', {table: table}) 
})

// View sử dụng layout mặc định là layout "main"
app.get('/about', (req, res) => {
    res.render('about');
})

// View sử dụng một layout khác thay vì layout mặc định là "main"
app.get('/custom-layout', (req, res) => {
    res.render('custom-layout', {layout: 'custom'});
})

// View không có bất kỳ layout nào
app.get('/no-layout', (req, res) => {
    res.render('no-layout', {layout: null});
})

// Thay vì render một view thì chỉ show text plain lên thôi
app.get('/text', (req, res) => {
    res.type('text/plain') // content type. Mặc định là text/html nếu không ghi
    res.send('That page has no view. It just a only plain text.')
})

// Middle ware custom 404 error
app.use((req, res) => {
    res.status(404) // status code. Mặc định là 200 nếu không ghi
    res.render('404')
})

// Middle ware custom 500 error
app.use((err, req, res, next) => {
    console.error(err.message) // hiển thị nội dung lên màn hình console
    res.status(500)
    res.render('500')
})

// Tạo server trên cổng 8080
app.listen(8080)
