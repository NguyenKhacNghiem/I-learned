let express = require('express');
let app = express();
let cookieParser = require('cookie-parser');
let credentials = require('./credentials'); 
let session = require('express-session');

app.use(cookieParser(credentials.cookieSign));
app.use(session({
    secret: credentials.cookieSign,
    resave: true,
    saveUninitialized: true,

}));

app.get('/', (req, res) => {
    req.session.name = "Peter";
    res.send("Trang này tạo session")
})

app.get('/read-session', (req, res) => {
    let name = req.session.name;
    console.log('Name: ' + name)

    res.send("Trang này đọc session. Xem trong console")
})

app.get('/delete-session', (req, res) => {
    // req.session.name = null; // gán value bằng null chứ ko hề xóa
    delete req.session.name; // xóa session

    res.send("Trang này xóa session.")
})

app.listen(8080)