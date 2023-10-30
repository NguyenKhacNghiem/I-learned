const express = require('express');
const hbs = require('express-handlebars')
const fs = require('fs');
const path = require('path');


const app = express();

app.engine('handlebars', hbs.engine({
    defaultLayout: 'main'
}))
app.set('view engine', 'handlebars')

// mặc định express.json() chỉ chấp nhận request 100KB. Mà upload file bằng Base64 thường request sẽ rất lớn nên chúng ta cần điều chỉnh lại limit
app.use(express.json({limit: '1mb'}));

app.get("/", (req, res) => {
    res.render("index")
})

app.get("/upload", (req, res) => {
    res.render("upload")
})

app.get("/display", (req, res) => {
    // Đọc danh sách các file có trong thư mục upload để hiển thị lên <select>
    let uploadsDirectory = `${__dirname}/uploads`; 

    // Sử dụng fs.readdir để đọc danh sách các file trong thư mục
    fs.readdir(uploadsDirectory, (err, files) => {
        if (err)
            res.status(500).send('Internal Server Error');
        else {
            // Lọc ra các file là hình ảnh
            let imageFiles = files.filter(file => {
                let extname = path.extname(file).toLowerCase();

                return extname === '.png' || extname === '.jpg' || extname === '.jpeg' || extname === '.gif' || extname === '.bmp';
            });

            res.render("display", {imageFiles: imageFiles})
        }
    });
})

// upload (client to server)
app.post('/upload-image', (req, res) => {
    let base64 = req.body.base64.replace(/^data:image\/\w+;base64,/, '');
    let buffer = Buffer.from(base64, 'base64');

    // Tạo tên tệp ngẫu nhiên để lưu hình ảnh (vì base64 là chuỗi nên sẽ không có tên file)
    let imageName = Date.now() + '.png';

    // Tạo thư mục uploads nếu nó chưa tồn tại
    let uploadsDirectory = `${__dirname}/uploads`;
    if (!fs.existsSync(uploadsDirectory))
        fs.mkdirSync(uploadsDirectory);

    // Lưu hình ảnh vào thư mục 'uploads'
    fs.writeFile(`${__dirname}/uploads/${imageName}`, buffer, (error) => {
        if (error)
            res.json({error: error})
        else 
            res.json({success: `Your image ${imageName} uploaded successfully`})
    });
});

// display (server to client)
app.get('/get-image/:name', (req, res) => {
    // Đọc hình ảnh từ tệp và chuyển thành dạng base64
    let imageName = __dirname + `/uploads/${req.params.name}`; // Đường dẫn đến tệp hình ảnh
    let imageBuffer = fs.readFileSync(imageName);
    let base64Image = Buffer.from(imageBuffer).toString('base64');

    // Gửi hình ảnh dưới dạng base64 trong phản hồi
    res.send({ image: base64Image });
});

app.listen(8080);
