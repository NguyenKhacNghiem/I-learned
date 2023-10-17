const express = require('express');
const app = express();

// Khi vô 1 đường dẫn, sẽ thực hiện nhiều hàm callback thay vì 1
app.get('/user/:id', (req, res, next) => {
    // Nếu id = 0 thì không thực hiện hàm callback thứ 2 mà next qua route hợp lệ tiếp theo (special)
    // Ngược lại thì thực hiện callback thứ 2 (regular)
    if (req.params.id == 0) 
        next('route');
    else 
        next();
}, (req, res, next) => {
    res.end('regular');
});

app.get('/user/:id', (req, res, next) => { 
    res.end('special'); 
});

// Tách nhiều hàm callback ra riêng cho dễ
let cb1 = function (req, res, next) { 
    console.log('CB1'); 
    next(); 
}

let cb2 = function (req, res, next) { 
    console.log('CB2'); 
    next(); 
}

let cb3 = function (req, res) { 
    console.log('CB3'); 
    res.end();
}

app.get('/about', [cb1, cb2, cb3])

app.listen(8080)
