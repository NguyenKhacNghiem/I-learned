const express = require('express');
const app = express();

const pdf = require(__dirname + '/main.js');

app.use(express.json());

app.get('/', (req, res) => {
    // Hiển thị file PDF trực tiếp trên trình duyệt
    res.writeHead(200, {
        'Content-Type': 'application/pdf',
        'Content-Disposition': 'inline; filename="my-file.pdf"' // inline -> attachment để tự động tải xuống
    });

    pdf.createPDF(
        data => res.write(data), // Gửi dữ liệu PDF trực tiếp về client
        () => res.end()          // Kết thúc response khi hoàn thành
    );
});

app.listen(3000, () => console.log('Visit http://localhost:3000'));
