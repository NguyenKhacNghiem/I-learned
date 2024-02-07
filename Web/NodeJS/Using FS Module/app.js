const fs = require('fs');

// Kiểm tra file/ folder có tồn tại hay không
console.log(fs.existsSync(__dirname + "/file 1.txt"));
console.log(fs.existsSync(__dirname + "/folder 1"));

// Kiểm tra là file hay folder
console.log(fs.lstatSync(__dirname + "/file 1.txt").isDirectory());
console.log(fs.lstatSync(__dirname + "/folder 1").isDirectory());

// Lấy thông tin của file/ folder
console.log(fs.lstatSync(__dirname + "/file 1.txt"));
console.log(fs.lstatSync(__dirname + "/folder 1"));
console.log(fs.statSync(__dirname + "/file 1.txt"));
console.log(fs.statSync(__dirname + "/folder 1"));

// Tạo file
fs.writeFileSync(__dirname + "/new file.txt", "Hello World.");

// Tạo folder (nếu tồn tại rồi sẽ báo lỗi)
fs.mkdirSync(__dirname + "/New Folder");

// Đổi tên file/ folder
fs.renameSync(__dirname + "/new file.txt", __dirname + "/new file 2.txt");
fs.renameSync(__dirname + "/New Folder", __dirname + "/New Folder 2");

// Xóa file
fs.unlinkSync(__dirname + "/new file 2.txt");

// Xóa folder
fs.rmdirSync(__dirname + "/New Folder 2");

// Lấy danh sách các file và folder nằm bên trong folder
console.log(fs.readdirSync(__dirname + "/folder 1"));

// Download file/ folder: cái này có làm ra một file riêng rồi