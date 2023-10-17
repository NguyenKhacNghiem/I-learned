const express = require('express');
const hbs = require('express-handlebars')
const fs = require('fs');

const app = express();

app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', // mặc định sử dụng layout main (file main.handlebars)
                           // ... nếu có các layout khác thì ghi vô
}))
app.set('view engine', 'handlebars')

let autoViews = {}; // object chứa path tới các view tĩnh
app.use((req, res, next) => {
    let path = req.path.toLowerCase();

    if (autoViews[path]) // path nằm trong autoViews
        return res.render(autoViews[path]);
    
    // kiểm tra file view trong thư mục /views có tồn tại không
    if (fs.existsSync(__dirname + '/views' + path + '.handlebars')) {
        autoViews[path] = path.replace(/^\//, '');
        return res.render(autoViews[path]);
    }

    // Nếu không tìm thấy view nào phù hợp để render thì next qua cho middleware khác xử lý 
    // (có thể là middleware lỗi, 404, ...)
    next();
});

app.get("/", (req, res) => {
    res.render("index");
})

// Đối với những view hiển thị nội dung tĩnh như thế này. Trong trường hợp có nhiều view thì chúng ta chỉ cần 1 middleware là có thể render ra được nhiều view cùng lúc thay vì phải app.get() riêng cho từng view

// app.get("about", (req, res) => {
//     res.render("about");
// })

// app.get("contact", (req, res) => {
//     res.render("contact");
// })

// app.get("term", (req, res) => {
//     res.render("term");
// })

// 404
app.use((req, res) => {
    res.status(404)
    res.render('404')
})

app.listen(8080)