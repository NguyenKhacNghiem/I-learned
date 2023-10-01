let express = require('express');
let app = express();
let cookieParser = require('cookie-parser');
let session = require('express-session');
let flash = require('connect-flash');

app.use(cookieParser("NguyenKhacNghiem"));
app.use(session({
    secret: "NguyenKhacNghiem", // private key để ký cho cái cookie mà lưu session id
    resave: true,
    saveUninitialized: true,
}));

app.use(flash())

app.get('/', (req, res) => {
    if(req.session.login) 
        res.send(`<p>${req.flash("message")}</p>`); // lấy ra giá trị mà flash message chứa
    else 
        res.send("Access /add to view flash message");
})

app.get('/add', (req, res) => {
    req.session.login = true;

    req.flash("message", "Add success"); // tạo ra 1 flash message theo dạng key-value
    res.redirect("/");
})

app.listen(8080)